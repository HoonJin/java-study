package com.hoonjin.study.kotlin.commerce.core.domain

import com.hoonjin.study.kotlin.commerce.core.enums.EntityStatus
import com.hoonjin.study.kotlin.commerce.core.enums.OrderState
import com.hoonjin.study.kotlin.commerce.core.enums.PaymentState
import com.hoonjin.study.kotlin.commerce.core.enums.PointType
import com.hoonjin.study.kotlin.commerce.core.enums.TransactionType
import com.hoonjin.study.kotlin.commerce.core.support.error.CoreException
import com.hoonjin.study.kotlin.commerce.core.support.error.ErrorType
import com.hoonjin.study.kotlin.commerce.storage.db.core.CancelEntity
import com.hoonjin.study.kotlin.commerce.storage.db.core.CancelRepository
import com.hoonjin.study.kotlin.commerce.storage.db.core.OrderRepository
import com.hoonjin.study.kotlin.commerce.storage.db.core.OwnedCouponRepository
import com.hoonjin.study.kotlin.commerce.storage.db.core.PaymentRepository
import com.hoonjin.study.kotlin.commerce.storage.db.core.TransactionHistoryEntity
import com.hoonjin.study.kotlin.commerce.storage.db.core.TransactionHistoryRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class CancelService(
    private val paymentRepository: PaymentRepository,
    private val orderRepository: OrderRepository,
    private val ownedCouponRepository: OwnedCouponRepository,
    private val cancelRepository: CancelRepository,
    private val transactionHistoryRepository: TransactionHistoryRepository,
    private val pointHandler: PointHandler,
) {

    @Transactional
    fun cancel(user: User, action: CancelAction): Long {
        val order = orderRepository.findByOrderKeyAndStateAndStatus(action.orderKey, OrderState.PAID, EntityStatus.ACTIVE) ?: throw CoreException(ErrorType.NOT_FOUND_DATA)
        if (order.userId != user.id) throw CoreException(ErrorType.NOT_FOUND_DATA)

        val payment = paymentRepository.findByOrderId(order.id) ?: throw CoreException(ErrorType.NOT_FOUND_DATA)
        if (payment.state != PaymentState.SUCCESS) throw CoreException(ErrorType.PAYMENT_INVALID_STATE)

        /**
         * NOTE: PG 취소 API 호출 => 성공 시 다음 로직으로 진행 | 실패 시 예외 발생
         */

        order.canceled()

        if (payment.hasAppliedCoupon()) {
            ownedCouponRepository.findByIdOrNull(payment.ownedCouponId)?.revert()
        }

        pointHandler.earn(User(payment.userId), PointType.PAYMENT, payment.id, payment.usedPoint)
        pointHandler.deduct(User(payment.userId), PointType.PAYMENT, payment.id, PointAmount.PAYMENT)

        val cancel = cancelRepository.save(
            CancelEntity(
                userId = payment.userId,
                orderId = payment.orderId,
                paymentId = payment.id,
                originAmount = payment.originAmount,
                ownedCouponId = payment.ownedCouponId,
                couponDiscount = payment.couponDiscount,
                usedPoint = payment.usedPoint,
                paidAmount = payment.paidAmount,
                canceledAmount = payment.paidAmount,
                externalCancelKey = "PG_API_응답_취소_고유_값_저장",
                canceledAt = LocalDateTime.now(),
            ),
        )

        transactionHistoryRepository.save(
            TransactionHistoryEntity(
                type = TransactionType.CANCEL,
                userId = payment.userId,
                orderId = payment.orderId,
                paymentId = payment.id,
                externalPaymentKey = payment.externalPaymentKey!!,
                amount = payment.paidAmount,
                message = "취소 성공",
                occurredAt = cancel.canceledAt,
            ),
        )

        return cancel.id
    }
}

package com.hoonjin.study.kotlin.commerce.core.domain

import com.hoonjin.study.kotlin.commerce.core.enums.EntityStatus
import com.hoonjin.study.kotlin.commerce.core.enums.OrderState
import com.hoonjin.study.kotlin.commerce.core.enums.PaymentMethod
import com.hoonjin.study.kotlin.commerce.core.enums.PaymentState
import com.hoonjin.study.kotlin.commerce.core.enums.PointType
import com.hoonjin.study.kotlin.commerce.core.enums.TransactionType
import com.hoonjin.study.kotlin.commerce.core.support.error.CoreException
import com.hoonjin.study.kotlin.commerce.core.support.error.ErrorType
import com.hoonjin.study.kotlin.commerce.storage.db.core.OrderRepository
import com.hoonjin.study.kotlin.commerce.storage.db.core.OwnedCouponRepository
import com.hoonjin.study.kotlin.commerce.storage.db.core.PaymentEntity
import com.hoonjin.study.kotlin.commerce.storage.db.core.PaymentRepository
import com.hoonjin.study.kotlin.commerce.storage.db.core.TransactionHistoryEntity
import com.hoonjin.study.kotlin.commerce.storage.db.core.TransactionHistoryRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.time.LocalDateTime

@Service
class PaymentService(
    private val paymentRepository: PaymentRepository,
    private val orderRepository: OrderRepository,
    private val transactionHistoryRepository: TransactionHistoryRepository,
    private val pointHandler: PointHandler,
    private val ownedCouponRepository: OwnedCouponRepository,
) {
    @Transactional
    fun createPayment(
        order: Order,
        paymentDiscount: PaymentDiscount,
    ): Long {
        if (paymentRepository.findByOrderId(order.id)?.state == PaymentState.SUCCESS) {
            throw CoreException(ErrorType.ORDER_ALREADY_PAID)
        }

        val payment = PaymentEntity(
            userId = order.userId,
            orderId = order.id,
            originAmount = order.totalPrice,
            ownedCouponId = paymentDiscount.useOwnedCouponId,
            couponDiscount = paymentDiscount.couponDiscount,
            usedPoint = paymentDiscount.usePoint,
            paidAmount = paymentDiscount.paidAmount(order.totalPrice),
            state = PaymentState.READY,
        )
        return paymentRepository.save(payment).id
    }

    @Transactional
    fun success(orderKey: String, externalPaymentKey: String, amount: BigDecimal): Long {
        val order = orderRepository.findByOrderKeyAndStateAndStatus(orderKey, OrderState.CREATED, EntityStatus.ACTIVE) ?: throw CoreException(ErrorType.NOT_FOUND_DATA)

        val payment = paymentRepository.findByOrderId(order.id) ?: throw CoreException(ErrorType.NOT_FOUND_DATA)
        if (payment.userId != order.userId) throw CoreException(ErrorType.NOT_FOUND_DATA)
        if (payment.state != PaymentState.READY) throw CoreException(ErrorType.PAYMENT_INVALID_STATE)
        if (payment.paidAmount != amount) throw CoreException(ErrorType.PAYMENT_AMOUNT_MISMATCH)

        /**
         * NOTE: PG 승인 API 호출 => 성공 시 다음 로직으로 진행 | 실패 시 예외 발생
         */

        payment.success(
            externalPaymentKey,
            // NOTE: PG 승인 API 호출의 응답 값 중 `결제 수단` 넣기
            PaymentMethod.CARD,
            "PG 승인 API 호출의 응답 값 중 `승인번호` 넣기",
        )
        order.paid()

        if (payment.hasAppliedCoupon()) {
            ownedCouponRepository.findByIdOrNull(payment.ownedCouponId)?.use()
        }

        pointHandler.deduct(User(payment.userId), PointType.PAYMENT, payment.id, payment.usedPoint)
        pointHandler.earn(User(payment.userId), PointType.PAYMENT, payment.id, PointAmount.PAYMENT)

        transactionHistoryRepository.save(
            TransactionHistoryEntity(
                type = TransactionType.PAYMENT,
                userId = order.userId,
                orderId = order.id,
                paymentId = payment.id,
                externalPaymentKey = externalPaymentKey,
                amount = payment.paidAmount,
                message = "결제 성공",
                occurredAt = payment.paidAt!!,
            ),
        )
        return payment.id
    }

    fun fail(orderKey: String, code: String, message: String) {
        val order = orderRepository.findByOrderKeyAndStateAndStatus(orderKey, OrderState.CREATED, EntityStatus.ACTIVE) ?: throw CoreException(ErrorType.NOT_FOUND_DATA)
        val payment = paymentRepository.findByOrderId(order.id) ?: throw CoreException(ErrorType.NOT_FOUND_DATA)

        transactionHistoryRepository.save(
            TransactionHistoryEntity(
                type = TransactionType.PAYMENT_FAIL,
                userId = order.userId,
                orderId = order.id,
                paymentId = payment.id,
                externalPaymentKey = "",
                amount = BigDecimal.valueOf(-1),
                message = "[$code] $message",
                occurredAt = LocalDateTime.now(),
            ),
        )
    }
}

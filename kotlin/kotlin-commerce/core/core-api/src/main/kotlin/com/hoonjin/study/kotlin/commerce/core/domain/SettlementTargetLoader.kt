package com.hoonjin.study.kotlin.commerce.core.domain

import com.hoonjin.study.kotlin.commerce.core.enums.TransactionType
import com.hoonjin.study.kotlin.commerce.storage.db.core.MerchantProductMappingRepository
import com.hoonjin.study.kotlin.commerce.storage.db.core.OrderItemEntity
import com.hoonjin.study.kotlin.commerce.storage.db.core.OrderItemRepository
import com.hoonjin.study.kotlin.commerce.storage.db.core.SettlementTargetEntity
import com.hoonjin.study.kotlin.commerce.storage.db.core.SettlementTargetRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class SettlementTargetLoader(
    private val settlementTargetRepository: SettlementTargetRepository,
    private val orderItemRepository: OrderItemRepository,
    private val merchantProductMappingRepository: MerchantProductMappingRepository,
) {
    @Transactional
    fun process(
        settleDate: LocalDate,
        transactionType: TransactionType,
        transactionIdMap: Map<Long, Long>,
    ) {
        val orderItems: List<OrderItemEntity> = orderItemRepository.findByOrderIdIn(transactionIdMap.keys)

        val merchantMappingMap = merchantProductMappingRepository
            .findByProductIdIn(orderItems.map { it.productId }.toSet())
            .associateBy { it.productId }

        val targets = orderItems.map { item ->
            SettlementTargetEntity(
                settlementDate = settleDate,
                merchantId = merchantMappingMap[item.productId]?.merchantId ?: throw IllegalStateException("상품 ${item.productId} 의 가맹점 매핑이 존재하지 않음"),
                transactionType = transactionType,
                transactionId = transactionIdMap[item.orderId] ?: throw IllegalStateException("주문 ${item.orderId} 의 거래 ID 매핑이 존재하지 않음"),
                orderId = item.orderId,
                productId = item.productId,
                quantity = item.quantity,
                unitPrice = item.unitPrice,
                totalPrice = item.totalPrice,
                targetAmount = when (transactionType) {
                    TransactionType.PAYMENT -> item.totalPrice
                    TransactionType.CANCEL -> item.totalPrice.negate()
                    else -> throw UnsupportedOperationException()
                },
            )
        }
        settlementTargetRepository.saveAll(targets)
    }
}

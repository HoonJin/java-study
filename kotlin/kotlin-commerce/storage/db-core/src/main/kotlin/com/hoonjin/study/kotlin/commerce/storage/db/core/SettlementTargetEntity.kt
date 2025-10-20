package com.hoonjin.study.kotlin.commerce.storage.db.core

import com.hoonjin.study.kotlin.commerce.core.enums.TransactionType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "settlement_target")
class SettlementTargetEntity(
    val merchantId: Long,
    val settlementDate: LocalDate,
    val targetAmount: BigDecimal,
    @Enumerated(EnumType.STRING)
    val transactionType: TransactionType,
    val transactionId: Long,
    val orderId: Long,
    val productId: Long,
    val quantity: Long,
    val unitPrice: BigDecimal,
    val totalPrice: BigDecimal,
) : BaseEntity()

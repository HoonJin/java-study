package com.hoonjin.study.kotlin.commerce.core.domain

import com.hoonjin.study.kotlin.commerce.core.enums.PointType
import java.math.BigDecimal
import java.time.LocalDateTime

data class PointHistory(
    val id: Long,
    val userId: Long,
    val type: PointType,
    val referenceId: Long,
    val amount: BigDecimal,
    val appliedAt: LocalDateTime,
)

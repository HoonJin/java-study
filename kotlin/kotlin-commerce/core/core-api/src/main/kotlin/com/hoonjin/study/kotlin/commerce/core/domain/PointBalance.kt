package com.hoonjin.study.kotlin.commerce.core.domain

import java.math.BigDecimal

data class PointBalance(
    val userId: Long,
    val balance: BigDecimal,
)

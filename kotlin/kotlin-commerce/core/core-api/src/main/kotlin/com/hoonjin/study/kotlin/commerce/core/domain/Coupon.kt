package com.hoonjin.study.kotlin.commerce.core.domain

import com.hoonjin.study.kotlin.commerce.core.enums.CouponType
import java.math.BigDecimal
import java.time.LocalDateTime

data class Coupon(
    val id: Long,
    val name: String,
    val type: CouponType,
    val discount: BigDecimal,
    val expiredAt: LocalDateTime,
)

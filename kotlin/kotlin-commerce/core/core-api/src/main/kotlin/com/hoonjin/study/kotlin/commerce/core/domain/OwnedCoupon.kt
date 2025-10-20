package com.hoonjin.study.kotlin.commerce.core.domain

import com.hoonjin.study.kotlin.commerce.core.enums.OwnedCouponState

data class OwnedCoupon(
    val id: Long,
    val userId: Long,
    val state: OwnedCouponState,
    val coupon: Coupon,
)

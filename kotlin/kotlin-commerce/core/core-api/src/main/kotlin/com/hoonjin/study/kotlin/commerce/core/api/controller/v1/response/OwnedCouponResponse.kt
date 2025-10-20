package com.hoonjin.study.kotlin.commerce.core.api.controller.v1.response

import com.hoonjin.study.kotlin.commerce.core.domain.OwnedCoupon
import com.hoonjin.study.kotlin.commerce.core.enums.CouponType
import com.hoonjin.study.kotlin.commerce.core.enums.OwnedCouponState
import java.math.BigDecimal
import java.time.LocalDateTime

data class OwnedCouponResponse(
    val id: Long,
    val state: OwnedCouponState,
    val name: String,
    val type: CouponType,
    val discount: BigDecimal,
    val expiredAt: LocalDateTime,
) {
    companion object {
        fun of(ownedCoupon: OwnedCoupon): OwnedCouponResponse {
            return OwnedCouponResponse(
                id = ownedCoupon.id,
                state = ownedCoupon.state,
                name = ownedCoupon.coupon.name,
                type = ownedCoupon.coupon.type,
                discount = ownedCoupon.coupon.discount,
                expiredAt = ownedCoupon.coupon.expiredAt,
            )
        }
        fun of(ownedCoupons: List<OwnedCoupon>): List<OwnedCouponResponse> {
            return ownedCoupons.map { of(it) }
        }
    }
}

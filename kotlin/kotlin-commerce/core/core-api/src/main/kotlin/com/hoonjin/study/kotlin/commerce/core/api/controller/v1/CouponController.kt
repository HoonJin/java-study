package com.hoonjin.study.kotlin.commerce.core.api.controller.v1

import com.hoonjin.study.kotlin.commerce.core.api.controller.v1.response.OwnedCouponResponse
import com.hoonjin.study.kotlin.commerce.core.domain.OwnedCouponService
import com.hoonjin.study.kotlin.commerce.core.domain.User
import com.hoonjin.study.kotlin.commerce.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CouponController(
    private val ownedCouponService: OwnedCouponService,
) {
    @PostMapping("/v1/coupons/{couponId}/download")
    fun download(
        user: User,
        @PathVariable couponId: Long,
    ): ApiResponse<Any> {
        ownedCouponService.download(user, couponId)
        return ApiResponse.success()
    }

    @GetMapping("/v1/owned-coupons")
    fun getOwnedCoupons(
        user: User,
    ): ApiResponse<List<OwnedCouponResponse>> {
        val coupons = ownedCouponService.getOwnedCoupons(user)
        return ApiResponse.success(OwnedCouponResponse.of(coupons))
    }
}

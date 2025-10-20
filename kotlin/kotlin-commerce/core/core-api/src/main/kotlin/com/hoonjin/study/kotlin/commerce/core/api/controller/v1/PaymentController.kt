package com.hoonjin.study.kotlin.commerce.core.api.controller.v1

import com.hoonjin.study.kotlin.commerce.core.api.controller.v1.request.CreatePaymentRequest
import com.hoonjin.study.kotlin.commerce.core.api.controller.v1.response.CreatePaymentResponse
import com.hoonjin.study.kotlin.commerce.core.domain.OrderService
import com.hoonjin.study.kotlin.commerce.core.domain.OwnedCouponService
import com.hoonjin.study.kotlin.commerce.core.domain.PaymentService
import com.hoonjin.study.kotlin.commerce.core.domain.PointService
import com.hoonjin.study.kotlin.commerce.core.domain.User
import com.hoonjin.study.kotlin.commerce.core.enums.OrderState
import com.hoonjin.study.kotlin.commerce.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class PaymentController(
    private val paymentService: PaymentService,
    private val orderService: OrderService,
    private val ownedCouponService: OwnedCouponService,
    private val pointService: PointService,
) {
    @PostMapping("/v1/payments")
    fun create(
        user: User,
        @RequestBody request: CreatePaymentRequest,
    ): ApiResponse<CreatePaymentResponse> {
        val order = orderService.getOrder(user, request.orderKey, OrderState.CREATED)
        val ownedCoupons = ownedCouponService.getOwnedCouponsForCheckout(user, order.items.map { it.productId })
        val pointBalance = pointService.balance(user)
        val id = paymentService.createPayment(
            order = order,
            paymentDiscount = request.toPaymentDiscount(ownedCoupons, pointBalance),
        )
        return ApiResponse.success(CreatePaymentResponse(id))
    }

    @PostMapping("/v1/payments/callback/success")
    fun callbackForSuccess(
        @RequestParam orderId: String,
        @RequestParam paymentKey: String,
        @RequestParam amount: BigDecimal,
    ): ApiResponse<Any> {
        paymentService.success(
            orderKey = orderId,
            externalPaymentKey = paymentKey,
            amount = amount,
        )
        return ApiResponse.success()
    }

    @PostMapping("/v1/payments/callback/fail")
    fun callbackForFail(
        @RequestParam orderId: String,
        @RequestParam code: String,
        @RequestParam message: String,
    ): ApiResponse<Any> {
        paymentService.fail(
            orderKey = orderId,
            code = code,
            message = message,
        )
        return ApiResponse.success()
    }
}

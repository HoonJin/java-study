package com.hoonjin.study.kotlin.commerce.core.api.controller.v1

import com.hoonjin.study.kotlin.commerce.core.api.controller.v1.response.ProductDetailResponse
import com.hoonjin.study.kotlin.commerce.core.api.controller.v1.response.ProductResponse
import com.hoonjin.study.kotlin.commerce.core.domain.CouponService
import com.hoonjin.study.kotlin.commerce.core.domain.ProductSectionService
import com.hoonjin.study.kotlin.commerce.core.domain.ProductService
import com.hoonjin.study.kotlin.commerce.core.domain.ReviewService
import com.hoonjin.study.kotlin.commerce.core.domain.ReviewTarget
import com.hoonjin.study.kotlin.commerce.core.enums.ReviewTargetType
import com.hoonjin.study.kotlin.commerce.core.support.OffsetLimit
import com.hoonjin.study.kotlin.commerce.core.support.response.ApiResponse
import com.hoonjin.study.kotlin.commerce.core.support.response.PageResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    private val productService: ProductService,
    private val productSectionService: ProductSectionService,
    private val reviewService: ReviewService,
    private val couponService: CouponService,
) {
    @GetMapping("/v1/products")
    fun findProducts(
        @RequestParam categoryId: Long,
        @RequestParam offset: Int,
        @RequestParam limit: Int,
    ): ApiResponse<PageResponse<ProductResponse>> {
        val result = productService.findProducts(categoryId, OffsetLimit(offset, limit))
        return ApiResponse.success(PageResponse(ProductResponse.of(result.content), result.hasNext))
    }

    @GetMapping("/v1/products/{productId}")
    fun findProduct(
        @PathVariable productId: Long,
    ): ApiResponse<ProductDetailResponse> {
        val product = productService.findProduct(productId)
        val sections = productSectionService.findSections(productId)
        val rateSummary = reviewService.findRateSummary(ReviewTarget(ReviewTargetType.PRODUCT, productId))
        // NOTE: 별도 API 가 나을까?
        val coupons = couponService.getCouponsForProducts(listOf(productId))
        return ApiResponse.success(ProductDetailResponse(product, sections, rateSummary, coupons))
    }
}

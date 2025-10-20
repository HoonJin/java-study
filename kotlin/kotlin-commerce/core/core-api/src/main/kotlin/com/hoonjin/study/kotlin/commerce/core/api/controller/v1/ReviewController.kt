package com.hoonjin.study.kotlin.commerce.core.api.controller.v1

import com.hoonjin.study.kotlin.commerce.core.api.controller.v1.request.AddReviewRequest
import com.hoonjin.study.kotlin.commerce.core.api.controller.v1.request.UpdateReviewRequest
import com.hoonjin.study.kotlin.commerce.core.api.controller.v1.response.ReviewResponse
import com.hoonjin.study.kotlin.commerce.core.domain.ReviewService
import com.hoonjin.study.kotlin.commerce.core.domain.ReviewTarget
import com.hoonjin.study.kotlin.commerce.core.domain.User
import com.hoonjin.study.kotlin.commerce.core.enums.ReviewTargetType
import com.hoonjin.study.kotlin.commerce.core.support.OffsetLimit
import com.hoonjin.study.kotlin.commerce.core.support.response.ApiResponse
import com.hoonjin.study.kotlin.commerce.core.support.response.PageResponse
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ReviewController(
    private val reviewService: ReviewService,
) {
    @GetMapping("/v1/reviews")
    fun getReviews(
        @RequestParam targetType: ReviewTargetType,
        @RequestParam targetId: Long,
        @RequestParam offset: Int,
        @RequestParam limit: Int,
    ): ApiResponse<PageResponse<ReviewResponse>> {
        val page = reviewService.findReviews(ReviewTarget(targetType, targetId), OffsetLimit(offset, limit))
        return ApiResponse.success(PageResponse(ReviewResponse.of(page.content), page.hasNext))
    }

    @PostMapping("/v1/reviews")
    fun createReview(
        user: User,
        @RequestBody request: AddReviewRequest,
    ): ApiResponse<Any> {
        reviewService.addReview(user, request.toTarget(), request.toContent())
        return ApiResponse.success()
    }

    @PutMapping("/v1/reviews/{reviewId}")
    fun updateReview(
        user: User,
        @PathVariable reviewId: Long,
        @RequestBody request: UpdateReviewRequest,
    ): ApiResponse<Any> {
        reviewService.updateReview(user, reviewId, request.toContent())
        return ApiResponse.success()
    }

    @DeleteMapping("/v1/reviews/{reviewId}")
    fun deleteReview(
        user: User,
        @PathVariable reviewId: Long,
    ): ApiResponse<Any> {
        reviewService.removeReview(user, reviewId)
        return ApiResponse.success()
    }
}

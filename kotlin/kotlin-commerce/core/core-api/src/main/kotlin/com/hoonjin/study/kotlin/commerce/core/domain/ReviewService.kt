package com.hoonjin.study.kotlin.commerce.core.domain

import com.hoonjin.study.kotlin.commerce.core.enums.PointType
import com.hoonjin.study.kotlin.commerce.core.support.OffsetLimit
import com.hoonjin.study.kotlin.commerce.core.support.Page
import org.springframework.stereotype.Service

@Service
class ReviewService(
    private val reviewFinder: ReviewFinder,
    private val reviewManager: ReviewManager,
    private val reviewPolicyValidator: ReviewPolicyValidator,
    private val pointHandler: PointHandler,
) {
    fun findRateSummary(target: ReviewTarget): RateSummary {
        return reviewFinder.findRateSummary(target)
    }

    fun findReviews(target: ReviewTarget, offsetLimit: OffsetLimit): Page<Review> {
        return reviewFinder.find(target, offsetLimit)
    }

    fun addReview(user: User, target: ReviewTarget, content: ReviewContent): Long {
        val reviewKey = reviewPolicyValidator.validateNew(user, target)
        val reviewId = reviewManager.add(reviewKey, target, content)
        pointHandler.earn(user, PointType.REVIEW, reviewId, PointAmount.REVIEW)
        return reviewId
    }

    fun updateReview(user: User, reviewId: Long, content: ReviewContent): Long {
        reviewPolicyValidator.validateUpdate(user, reviewId)
        return reviewManager.update(user, reviewId, content)
    }

    fun removeReview(user: User, reviewId: Long): Long {
        val deletedReviewId = reviewManager.delete(user, reviewId)
        pointHandler.deduct(user, PointType.REVIEW, deletedReviewId, PointAmount.REVIEW)
        return deletedReviewId
    }
}

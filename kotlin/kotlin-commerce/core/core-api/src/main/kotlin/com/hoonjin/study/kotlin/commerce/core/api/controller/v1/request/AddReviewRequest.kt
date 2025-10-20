package com.hoonjin.study.kotlin.commerce.core.api.controller.v1.request

import com.hoonjin.study.kotlin.commerce.core.domain.ReviewContent
import com.hoonjin.study.kotlin.commerce.core.domain.ReviewTarget
import com.hoonjin.study.kotlin.commerce.core.enums.ReviewTargetType
import com.hoonjin.study.kotlin.commerce.core.support.error.CoreException
import com.hoonjin.study.kotlin.commerce.core.support.error.ErrorType
import java.math.BigDecimal

data class AddReviewRequest(
    val userId: Long,
    val targetType: ReviewTargetType,
    val targetId: Long,
    val rate: BigDecimal,
    val content: String,
) {
    fun toTarget(): ReviewTarget {
        return ReviewTarget(targetType, targetId)
    }

    fun toContent(): ReviewContent {
        if (rate <= BigDecimal.ZERO) throw CoreException(ErrorType.INVALID_REQUEST)
        if (rate > BigDecimal.valueOf(5.0)) throw CoreException(ErrorType.INVALID_REQUEST)
        if (content.isEmpty()) throw CoreException(ErrorType.INVALID_REQUEST)
        return ReviewContent(rate, content)
    }
}

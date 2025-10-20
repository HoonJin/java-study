package com.hoonjin.study.kotlin.commerce.core.domain

import com.hoonjin.study.kotlin.commerce.core.enums.ReviewTargetType

data class ReviewTarget(
    val type: ReviewTargetType,
    val id: Long,
)

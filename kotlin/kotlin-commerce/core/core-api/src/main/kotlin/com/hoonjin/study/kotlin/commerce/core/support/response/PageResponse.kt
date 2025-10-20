package com.hoonjin.study.kotlin.commerce.core.support.response

data class PageResponse<T>(
    val content: List<T>,
    val hasNext: Boolean,
)

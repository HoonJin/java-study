package com.hoonjin.study.kotlin.commerce.core.support

data class Page<T>(
    val content: List<T>,
    val hasNext: Boolean,
)

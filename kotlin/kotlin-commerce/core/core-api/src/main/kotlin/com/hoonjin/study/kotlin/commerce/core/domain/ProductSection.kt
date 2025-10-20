package com.hoonjin.study.kotlin.commerce.core.domain

import com.hoonjin.study.kotlin.commerce.core.enums.ProductSectionType

data class ProductSection(
    val type: ProductSectionType,
    val content: String,
)

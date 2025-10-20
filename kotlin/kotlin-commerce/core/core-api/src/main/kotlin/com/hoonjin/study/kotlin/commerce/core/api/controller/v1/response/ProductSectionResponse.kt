package com.hoonjin.study.kotlin.commerce.core.api.controller.v1.response

import com.hoonjin.study.kotlin.commerce.core.enums.ProductSectionType

data class ProductSectionResponse(
    val type: ProductSectionType,
    val content: String,
)

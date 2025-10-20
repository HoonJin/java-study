package com.hoonjin.study.kotlin.commerce.core.domain

import java.math.BigDecimal

data class Price(
    val costPrice: BigDecimal,
    val salesPrice: BigDecimal,
    val discountedPrice: BigDecimal,
)

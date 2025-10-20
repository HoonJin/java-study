package com.hoonjin.study.kotlin.commerce.core.domain

data class NewOrder(
    val userId: Long,
    val items: List<NewOrderItem>,
)

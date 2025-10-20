package com.hoonjin.study.kotlin.commerce.core.api.controller.v1.request

data class CreateOrderFromCartRequest(
    val cartItemIds: Set<Long>,
)

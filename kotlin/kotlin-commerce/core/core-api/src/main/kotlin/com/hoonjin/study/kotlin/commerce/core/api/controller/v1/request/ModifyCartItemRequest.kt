package com.hoonjin.study.kotlin.commerce.core.api.controller.v1.request

import com.hoonjin.study.kotlin.commerce.core.domain.ModifyCartItem

data class ModifyCartItemRequest(
    val quantity: Long,
) {
    fun toModifyCartItem(cartItemId: Long): ModifyCartItem {
        return ModifyCartItem(cartItemId, quantity)
    }
}

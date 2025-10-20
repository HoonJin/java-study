package com.hoonjin.study.kotlin.commerce.core.api.controller.v1.request

import com.hoonjin.study.kotlin.commerce.core.domain.AddCartItem
import com.hoonjin.study.kotlin.commerce.core.support.error.CoreException
import com.hoonjin.study.kotlin.commerce.core.support.error.ErrorType

data class AddCartItemRequest(
    val productId: Long,
    val quantity: Long,
) {
    fun toAddCartItem(): AddCartItem {
        if (quantity <= 0) throw CoreException(ErrorType.INVALID_REQUEST)
        return AddCartItem(productId, quantity)
    }
}

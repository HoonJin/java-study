package com.hoonjin.study.kotlin.commerce.core.api.controller.v1.request

import com.hoonjin.study.kotlin.commerce.core.domain.NewOrder
import com.hoonjin.study.kotlin.commerce.core.domain.NewOrderItem
import com.hoonjin.study.kotlin.commerce.core.domain.User
import com.hoonjin.study.kotlin.commerce.core.support.error.CoreException
import com.hoonjin.study.kotlin.commerce.core.support.error.ErrorType

data class CreateOrderRequest(
    val productId: Long,
    val quantity: Long,
) {
    fun toNewOrder(user: User): NewOrder {
        if (quantity <= 0) throw CoreException(ErrorType.INVALID_REQUEST)
        return NewOrder(
            userId = user.id,
            items = listOf(NewOrderItem(productId, quantity)),
        )
    }
}

package com.hoonjin.study.kotlin.commerce.core.api.controller.v1.request

import com.hoonjin.study.kotlin.commerce.core.domain.CancelAction

data class CancelRequest(
    val orderKey: String,
) {
    fun toCancelAction(): CancelAction {
        return CancelAction(orderKey)
    }
}

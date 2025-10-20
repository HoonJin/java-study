package com.hoonjin.study.kotlin.commerce.core.api.controller.v1

import com.hoonjin.study.kotlin.commerce.core.api.controller.v1.request.CancelRequest
import com.hoonjin.study.kotlin.commerce.core.domain.CancelService
import com.hoonjin.study.kotlin.commerce.core.domain.User
import com.hoonjin.study.kotlin.commerce.core.support.response.ApiResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CancelController(
    private val cancelService: CancelService,
) {
    @PostMapping("/v1/cancel")
    fun cancel(
        user: User,
        @RequestBody request: CancelRequest,
    ): ApiResponse<Any> {
        cancelService.cancel(user, request.toCancelAction())
        return ApiResponse.success()
    }
}

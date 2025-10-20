package com.hoonjin.study.kotlin.commerce.core.api.controller.v1.request

import com.hoonjin.study.kotlin.commerce.core.domain.QuestionContent
import com.hoonjin.study.kotlin.commerce.core.support.error.CoreException
import com.hoonjin.study.kotlin.commerce.core.support.error.ErrorType

data class UpdateQuestionRequest(
    val title: String,
    val content: String,
) {
    fun toContent(): QuestionContent {
        if (title.isEmpty()) throw CoreException(ErrorType.INVALID_REQUEST)
        if (title.length > 100) throw CoreException(ErrorType.INVALID_REQUEST)
        if (content.isEmpty()) throw CoreException(ErrorType.INVALID_REQUEST)

        return QuestionContent(
            title = title,
            content = content,
        )
    }
}

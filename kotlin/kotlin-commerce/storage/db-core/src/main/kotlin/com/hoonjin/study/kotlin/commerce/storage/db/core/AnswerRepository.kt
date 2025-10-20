package com.hoonjin.study.kotlin.commerce.storage.db.core

import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepository : JpaRepository<AnswerEntity, Long> {
    fun findByQuestionIdIn(questionId: List<Long>): List<AnswerEntity>
}

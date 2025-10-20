package com.hoonjin.study.kotlin.commerce.storage.db.core

import org.springframework.data.jpa.repository.JpaRepository

interface PointHistoryRepository : JpaRepository<PointHistoryEntity, Long> {
    fun findByUserId(userId: Long): List<PointHistoryEntity>
}

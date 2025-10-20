package com.hoonjin.study.kotlin.commerce.storage.db.core

import com.hoonjin.study.kotlin.commerce.core.enums.EntityStatus
import com.hoonjin.study.kotlin.commerce.core.enums.ReviewTargetType
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<ReviewEntity, Long> {
    fun findByIdAndUserId(id: Long, userId: Long): ReviewEntity?
    fun findByUserIdAndReviewKeyIn(userId: Long, reviewKey: Collection<String>): List<ReviewEntity>
    fun findByTargetTypeAndTargetId(target: ReviewTargetType, targetId: Long): List<ReviewEntity>
    fun findByTargetTypeAndTargetIdAndStatus(target: ReviewTargetType, targetId: Long, status: EntityStatus, slice: Pageable): Slice<ReviewEntity>
}

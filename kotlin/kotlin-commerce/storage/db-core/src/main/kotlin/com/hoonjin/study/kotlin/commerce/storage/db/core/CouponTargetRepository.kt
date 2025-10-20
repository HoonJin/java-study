package com.hoonjin.study.kotlin.commerce.storage.db.core

import com.hoonjin.study.kotlin.commerce.core.enums.CouponTargetType
import com.hoonjin.study.kotlin.commerce.core.enums.EntityStatus
import org.springframework.data.jpa.repository.JpaRepository

interface CouponTargetRepository : JpaRepository<CouponTargetEntity, Long> {
    fun findByTargetTypeAndTargetIdInAndStatus(target: CouponTargetType, targetId: Collection<Long>, status: EntityStatus): List<CouponTargetEntity>
}

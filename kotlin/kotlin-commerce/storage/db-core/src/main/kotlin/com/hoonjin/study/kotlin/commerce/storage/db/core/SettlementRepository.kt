package com.hoonjin.study.kotlin.commerce.storage.db.core

import com.hoonjin.study.kotlin.commerce.core.enums.SettlementState
import org.springframework.data.jpa.repository.JpaRepository

interface SettlementRepository : JpaRepository<SettlementEntity, Long> {
    fun findByState(state: SettlementState): List<SettlementEntity>
}

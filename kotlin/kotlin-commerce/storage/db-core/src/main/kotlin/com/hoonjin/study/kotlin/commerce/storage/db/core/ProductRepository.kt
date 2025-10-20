package com.hoonjin.study.kotlin.commerce.storage.db.core

import com.hoonjin.study.kotlin.commerce.core.enums.EntityStatus
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductEntity, Long> {
    fun findByIdInAndStatus(ids: Collection<Long>, status: EntityStatus): List<ProductEntity>
}

package com.hoonjin.study.kotlin.commerce.storage.db.core

import com.hoonjin.study.kotlin.commerce.core.enums.EntityStatus
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.jpa.repository.JpaRepository

interface ProductCategoryRepository : JpaRepository<ProductCategoryEntity, Long> {
    fun findByCategoryIdAndStatus(categoryId: Long, status: EntityStatus, pageable: Pageable): Slice<ProductCategoryEntity>
    fun findByProductIdInAndStatus(productIds: Collection<Long>, status: EntityStatus): List<ProductCategoryEntity>
}

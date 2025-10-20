package com.hoonjin.study.kotlin.commerce.storage.db.core

import com.hoonjin.study.kotlin.commerce.core.enums.EntityStatus
import org.springframework.data.jpa.repository.JpaRepository

interface CartItemRepository : JpaRepository<CartItemEntity, Long> {
    fun findByUserIdAndStatus(userId: Long, status: EntityStatus): List<CartItemEntity>
    fun findByUserIdAndIdAndStatus(userId: Long, id: Long, status: EntityStatus): CartItemEntity?
    fun findByUserIdAndProductId(userId: Long, productId: Long): CartItemEntity?
}

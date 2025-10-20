package com.hoonjin.study.kotlin.commerce.storage.db.core

import com.hoonjin.study.kotlin.commerce.core.enums.EntityStatus
import com.hoonjin.study.kotlin.commerce.core.enums.OrderState
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<OrderEntity, Long> {
    fun findByOrderKeyAndStateAndStatus(orderKey: String, state: OrderState, status: EntityStatus): OrderEntity?
    fun findByUserIdAndStateAndStatusOrderByIdDesc(userId: Long, state: OrderState, status: EntityStatus): List<OrderEntity>
}

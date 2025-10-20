package com.hoonjin.study.kotlin.commerce.storage.db.core

import com.hoonjin.study.kotlin.commerce.core.enums.CouponTargetType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table

@Entity
@Table(name = "coupon_target")
class CouponTargetEntity(
    val couponId: Long,
    @Enumerated(EnumType.STRING)
    val targetType: CouponTargetType,
    val targetId: Long,
) : BaseEntity()

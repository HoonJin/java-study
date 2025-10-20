package com.hoonjin.study.kotlin.commerce.core.domain

import com.hoonjin.study.kotlin.commerce.core.enums.CouponTargetType
import com.hoonjin.study.kotlin.commerce.core.enums.EntityStatus
import com.hoonjin.study.kotlin.commerce.storage.db.core.CouponRepository
import com.hoonjin.study.kotlin.commerce.storage.db.core.CouponTargetRepository
import com.hoonjin.study.kotlin.commerce.storage.db.core.ProductCategoryRepository
import org.springframework.stereotype.Service

@Service
class CouponService(
    private val couponRepository: CouponRepository,
    private val couponTargetRepository: CouponTargetRepository,
    private val productCategoryRepository: ProductCategoryRepository,
) {
    fun getCouponsForProducts(productIds: Collection<Long>): List<Coupon> {
        val productTargets = couponTargetRepository.findByTargetTypeAndTargetIdInAndStatus(
            CouponTargetType.PRODUCT,
            productIds,
            EntityStatus.ACTIVE,
        )
        val categoryTargets = couponTargetRepository.findByTargetTypeAndTargetIdInAndStatus(
            CouponTargetType.PRODUCT_CATEGORY,
            productCategoryRepository.findByProductIdInAndStatus(productIds, EntityStatus.ACTIVE).map { it.categoryId },
            EntityStatus.ACTIVE,
        )
        return couponRepository.findByIdInAndStatus((productTargets + categoryTargets).map { it.couponId }.toSet(), EntityStatus.ACTIVE)
            .map {
                Coupon(
                    id = it.id,
                    name = it.name,
                    type = it.type,
                    discount = it.discount,
                    expiredAt = it.expiredAt,
                )
            }
    }
}

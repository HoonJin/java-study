package com.hoonjin.study.kotlin.commerce.core.domain

import com.hoonjin.study.kotlin.commerce.core.support.OffsetLimit
import com.hoonjin.study.kotlin.commerce.core.support.Page
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productFinder: ProductFinder,
) {
    fun findProducts(categoryId: Long, offsetLimit: OffsetLimit): Page<Product> {
        return productFinder.findByCategory(categoryId, offsetLimit)
    }

    fun findProduct(productId: Long): Product {
        return productFinder.find(productId)
    }
}

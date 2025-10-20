package com.hoonjin.study.kotlin.commerce.core.domain

data class Product(
    val id: Long,
    val name: String,
    val thumbnailUrl: String,
    val description: String,
    val shortDescription: String,
    val price: Price,
)

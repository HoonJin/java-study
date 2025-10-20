package com.hoonjin.study.kotlin.commerce.storage.db.core

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "category")
class CategoryEntity(
    val categoryId: Long,
    val categoryName: Long,
) : BaseEntity()

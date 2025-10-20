package com.hoonjin.study.kotlin.commerce.storage.db.core

import org.springframework.data.jpa.repository.JpaRepository

interface TransactionHistoryRepository : JpaRepository<TransactionHistoryEntity, Long>

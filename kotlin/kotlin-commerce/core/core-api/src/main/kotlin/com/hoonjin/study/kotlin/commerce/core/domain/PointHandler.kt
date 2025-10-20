package com.hoonjin.study.kotlin.commerce.core.domain

import com.hoonjin.study.kotlin.commerce.core.enums.PointType
import com.hoonjin.study.kotlin.commerce.core.support.error.CoreException
import com.hoonjin.study.kotlin.commerce.core.support.error.ErrorType
import com.hoonjin.study.kotlin.commerce.storage.db.core.PointBalanceRepository
import com.hoonjin.study.kotlin.commerce.storage.db.core.PointHistoryEntity
import com.hoonjin.study.kotlin.commerce.storage.db.core.PointHistoryRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Component
class PointHandler(
    private val pointBalanceRepository: PointBalanceRepository,
    private val pointHistoryRepository: PointHistoryRepository,
) {
    @Transactional
    fun earn(user: User, type: PointType, targetId: Long, amount: BigDecimal) {
        if (amount == BigDecimal.ZERO) return

        // NOTE: 모든 유저는 가입 시 Point 테이블 생성
        val balance = pointBalanceRepository.findByUserId(user.id) ?: throw CoreException(ErrorType.NOT_FOUND_DATA)
        balance.apply(amount)
        pointHistoryRepository.save(
            PointHistoryEntity(
                userId = user.id,
                type = type,
                referenceId = targetId,
                amount = amount,
                balanceAfter = balance.balance,
            ),
        )
    }

    @Transactional
    fun deduct(user: User, type: PointType, targetId: Long, amount: BigDecimal) {
        if (amount == BigDecimal.ZERO) return

        // NOTE: 모든 유저는 가입 시 Point 테이블 생성
        val balance = pointBalanceRepository.findByUserId(user.id) ?: throw CoreException(ErrorType.NOT_FOUND_DATA)
        balance.apply(amount.negate())
        pointHistoryRepository.save(
            PointHistoryEntity(
                userId = user.id,
                type = type,
                referenceId = targetId,
                amount = amount.negate(),
                balanceAfter = balance.balance,
            ),
        )
    }
}

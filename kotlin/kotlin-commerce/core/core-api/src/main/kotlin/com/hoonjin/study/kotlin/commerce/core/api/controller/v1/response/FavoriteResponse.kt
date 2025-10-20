package com.hoonjin.study.kotlin.commerce.core.api.controller.v1.response

import com.hoonjin.study.kotlin.commerce.core.domain.Favorite
import java.time.LocalDateTime

data class FavoriteResponse(
    val id: Long,
    val productId: Long,
    val favoritedAt: LocalDateTime,
) {
    companion object {
        fun of(f: Favorite): FavoriteResponse {
            return FavoriteResponse(
                id = f.id,
                productId = f.productId,
                favoritedAt = f.favoritedAt,
            )
        }

        fun of(favorites: List<Favorite>): List<FavoriteResponse> {
            return favorites.map { of(it) }
        }
    }
}

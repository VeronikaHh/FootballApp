package com.example.core.data.remote.model.players

import com.example.core.domain.model.Game

data class GameDto(
    val position: String? = null,
    val rating: Double? = null,
)
fun GameDto.dtoToDomain(): Game {
    return Game(
        position = this.position,
        rating = this.rating
    )
}

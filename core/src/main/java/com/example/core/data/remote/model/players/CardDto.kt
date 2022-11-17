package com.example.core.data.remote.model.players

import com.example.core.domain.model.Card

data class CardDto(
    val yellow: Int? = null,
    val red: Int? = null
)
fun CardDto.dtoToDomain(): Card {
    return Card(
        yellow = this.yellow,
        red = this.red
    )
}

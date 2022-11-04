package com.example.core.data.remote.model.statistics

import com.example.core.domain.model.Score

data class ScoreDto(
    val away: String? = null,
    val home: String? = null
)

fun ScoreDto.dtoToDomain(): Score {
    return Score(
        away = this.away,
        home = this.home
    )
}
package com.example.core.data.remote.model.statistics

import com.example.core.domain.model.Biggest

data class BiggestDto(
    val loses: ScoreDto? = null,
    val streak: StreakDto? = null,
    val wins: ScoreDto? = null
)

fun BiggestDto.dtoToDomain(): Biggest {
    return Biggest(
        loses = this.loses?.let { this.loses.dtoToDomain() },
        streak = this.streak?.let { this.streak.dtoToDomain() },
        wins = this.wins?.let { this.wins.dtoToDomain() }
    )
}
package com.example.core.data.remote.model.statistics

import com.example.core.domain.model.Streak

data class StreakDto(
    val draws: Int? = null,
    val loses: Int? = null,
    val wins: Int? = null
)

fun StreakDto.dtoToDomain(): Streak {
    return Streak(
        draws = this.draws,
        loses = this.loses,
        wins = this.wins
    )
}


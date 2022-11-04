package com.example.core.data.remote.model.statistics

import com.example.core.domain.model.Fixtures

data class FixturesDto(
    val draws: TotalDto? = null,
    val loses: TotalDto? = null,
    val played: TotalDto? = null,
    val wins: TotalDto? = null
)

fun FixturesDto.dtoToDomain(): Fixtures {
    return Fixtures(
        draws = this.draws?.let { this.draws.dtoToDomain() },
        loses = this.loses?.let { this.loses.dtoToDomain() },
        played = this.played?.let { this.played.dtoToDomain() },
        wins = this.wins?.let { this.wins.dtoToDomain() }
    )
}
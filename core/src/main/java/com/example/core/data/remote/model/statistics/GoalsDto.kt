package com.example.core.data.remote.model.statistics

import com.example.core.domain.model.Goals

data class GoalsDto(
    val against: TotalAverageDto? = null,
    val `for`: TotalAverageDto? = null
)

fun GoalsDto.dtoToDomain(): Goals {
    return Goals(
        against = this.against?.let { this.against.dtoToDomain() },
        `for` = this.`for`?.let { this.`for`.dtoToDomain() }
    )
}
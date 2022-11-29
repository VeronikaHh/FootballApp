package com.example.core.data.remote.model.statistics

import com.example.core.domain.model.TotalAverage

data class TotalAverageDto(
    val total: TotalDto? = null,
    val average: TotalDto? = null
)

fun TotalAverageDto.dtoToDomain(): TotalAverage {
    return TotalAverage(
        total = this.total?.let { this.total.dtoToDomain() },
        average = this.average?.let { this.average.dtoToDomain() }
    )
}
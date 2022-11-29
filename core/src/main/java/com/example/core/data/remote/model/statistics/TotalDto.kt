package com.example.core.data.remote.model.statistics

import com.example.core.domain.model.Total

data class TotalDto(
    val away: Double? = null,
    val home: Double? = null,
    val total: Double? = null
)

fun TotalDto.dtoToDomain(): Total {
    return Total(
        away = this.away,
        home = this.home,
        total = this.total
    )
}
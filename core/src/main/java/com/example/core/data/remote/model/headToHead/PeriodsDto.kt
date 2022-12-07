package com.example.core.data.remote.model.headToHead

import com.example.core.domain.model.Periods

data class PeriodsDto(
    val first: Int? = null,
    val second: Int? = null
)

fun PeriodsDto.dtoToDomain(): Periods {
    return Periods(
        first = this.first,
        second = this.second
    )
}
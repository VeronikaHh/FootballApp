package com.example.core.data.remote.model.players

import com.example.core.domain.model.Goal

data class GoalDto(
    val total: Int? = null,
    val assists: Int? = null
)
fun GoalDto.dtoToDomain(): Goal {
    return Goal(
        total = this.total,
        assists = this.assists
    )
}
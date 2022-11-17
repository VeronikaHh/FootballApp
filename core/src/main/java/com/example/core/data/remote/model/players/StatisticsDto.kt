package com.example.core.data.remote.model.players

import com.example.core.data.remote.model.statistics.LeagueDto
import com.example.core.data.remote.model.teams.TeamDto

data class StatisticsDto(
    val team: TeamDto? = null,
    val league: LeagueDto? = null,
    val games: GameDto? = null,
    val goals: GoalDto? = null,
    val cards: CardDto? = null
)
//fun StatisticsDto.dtoToDomain(): Statistics {
//
//}
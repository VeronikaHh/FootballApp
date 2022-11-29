package com.example.core.data.remote.model.players

import com.example.core.data.mapper.LeagueMapper
import com.example.core.data.mapper.TeamMapper
import com.example.core.data.remote.model.statistics.LeagueDto
import com.example.core.data.remote.model.teams.TeamDto
import com.example.core.domain.model.Statistics

data class StatisticsDto(
    val team: TeamDto? = null,
    val league: LeagueDto? = null,
    val games: GameDto? = null,
    val goals: GoalDto? = null,
    val cards: CardDto? = null
)

fun StatisticsDto.dtoToDomain(
    teamMapper: TeamMapper,
    leagueMapper: LeagueMapper
): Statistics {
    return Statistics(
        team = team?.let { teamMapper.dtoToDomain(it) },
        league = league?.let { leagueMapper.dtoToDomain(it) },
        games = games?.dtoToDomain(),
        goals = goals?.dtoToDomain(),
        cards = cards?.dtoToDomain()
    )
}
package com.example.core.data.remote.model.statistics

import com.example.core.data.remote.model.teams.TeamDto

data class TeamStatisticsDto(
    val biggest: BiggestDto? = null,
    val clean_sheet: TotalDto? = null,
    val fixtures: FixturesDto? = null,
    val form: String? = null,
    val goals: GoalsDto? = null,
    val league: LeagueDto? = null,
    val team: TeamDto? = null
)


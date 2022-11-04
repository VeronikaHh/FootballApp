package com.example.core.data.remote.model.statistics

import com.example.core.data.mapper.LeagueMapper
import com.example.core.data.mapper.TeamMapper
import com.example.core.data.remote.model.teams.TeamDto
import com.example.core.domain.model.TeamStatistics

data class TeamStatisticsDto(
    val biggest: BiggestDto? = null,
    val clean_sheet: TotalDto? = null,
    val fixtures: FixturesDto? = null,
    val form: String? = null,
    val goals: GoalsDto? = null,
    val league: LeagueDto? = null,
    val team: TeamDto? = null
)

fun TeamStatisticsDto.dtoToDomain(): TeamStatistics {
    return TeamStatistics(
        biggest = this.biggest?.let { this.biggest.dtoToDomain() },
        clean_sheet = this.clean_sheet?.let { this.clean_sheet.dtoToDomain() },
        fixtures = this.fixtures?.let { this.fixtures.dtoToDomain() },
        form = this.form,
        goals = this.goals?.let { this.goals.dtoToDomain() },
        league = this.league?.let { LeagueMapper().dtoToDomain(this.league) },
        team = this.team?.let { TeamMapper().dtoToDomain(this.team) }
    )
}


package com.example.core.data.remote.datasource

import com.example.core.data.remote.model.response.Response
import com.example.core.data.remote.model.statistics.TeamStatisticsDto
import com.example.core.data.remote.model.teams.TeamInfoDto
import com.example.core.data.remote.service.TeamService

class TeamRemoteDataSource(
    private val teamService: TeamService,
) {
    suspend fun fetchTeams(id: Int): Response<List<TeamInfoDto>> =
        teamService.fetchTeams(id)

    suspend fun fetchTeams(search: String): Response<List<TeamInfoDto>> =
        teamService.fetchTeams(search)

    suspend fun fetchTeams(league: Int, season: Int): Response<List<TeamInfoDto>> =
        teamService.fetchTeams(league, season)

    suspend fun fetchTeamStatistics(season: Int, teamId: Int, leagueId: Int): Response<TeamStatisticsDto> {
        return teamService.fetchTeamStatistics(season, teamId, leagueId)
    }
}
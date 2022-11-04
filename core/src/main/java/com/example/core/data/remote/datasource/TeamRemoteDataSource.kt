package com.example.core.data.remote.datasource

import com.example.core.data.remote.model.response.Response
import com.example.core.data.remote.model.statistics.TeamStatisticsDto
import com.example.core.data.remote.model.teams.TeamsDto
import com.example.core.data.remote.service.TeamService

class TeamRemoteDataSource(
    private val teamService: TeamService,
) {
    suspend fun fetchTeams(): Response<List<TeamsDto>> =
        teamService.fetchTeams(1)

    suspend fun fetchTeamStatistics(): Response<TeamStatisticsDto> =
        teamService.fetchTeamStatistics(1, 1, 1)
}
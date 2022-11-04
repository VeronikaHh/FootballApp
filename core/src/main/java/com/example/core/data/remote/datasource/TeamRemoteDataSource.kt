package com.example.core.data.remote.datasource

import com.example.core.data.remote.model.response.Response
import com.example.core.data.remote.model.statistics.TeamStatistics
import com.example.core.data.remote.model.teams.Teams
import com.example.core.data.remote.service.TeamService
import kotlinx.coroutines.CoroutineDispatcher

class TeamRemoteDataSource(
    private val teamService: TeamService,
) {
    suspend fun fetchTeams(): Response<List<Teams>> =
        teamService.fetchTeams(1)

    suspend fun fetchTeamStatistics(): Response<TeamStatistics> =
        teamService.fetchTeamStatistics(1, 1, 1)
}
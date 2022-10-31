package com.example.core.data.datasource.remote

import com.example.core.data.model.remote.response.Response
import com.example.core.data.model.remote.statistics.TeamStatistics
import com.example.core.data.model.remote.teams.Teams
import com.example.core.data.service.TeamService
import kotlinx.coroutines.CoroutineDispatcher

class TeamRemoteDataSource(
    private val teamService: TeamService,
) {
    suspend fun fetchTeams(): Response<List<Teams>> =
        teamService.fetchTeams(1)

    suspend fun fetchTeamStatistics(): Response<TeamStatistics> =
        teamService.fetchTeamStatistics(1, 1, 1)
}
package com.example.core.data.remote.datasource

import com.example.core.data.remote.model.response.Response
import com.example.core.data.remote.model.statistics.TeamStatisticsDto
import com.example.core.data.remote.model.teams.TeamInfoDto
import com.example.core.data.remote.service.LeagueService
import com.example.core.data.remote.service.TeamService

class LeagueRemoteDataSource(
    private val leagueService: LeagueService,
) {
    suspend fun fetchLeagues(leagueId: Int): Response<List<???>> =
        leagueService.fetchLeagues(leagueId)

    suspend fun fetchLeagues(teamId: Int, season: Int): Response<List<???>> =
        leagueService.fetchLeagues(teamId, season)
}
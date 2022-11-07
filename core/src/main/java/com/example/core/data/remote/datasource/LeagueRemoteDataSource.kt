package com.example.core.data.remote.datasource

import com.example.core.data.remote.model.response.Response
import com.example.core.data.remote.model.statistics.LeagueInfoDto
import com.example.core.data.remote.service.LeagueService

class LeagueRemoteDataSource(
    private val leagueService: LeagueService,
) {
    suspend fun fetchLeagues(leagueId: Int): Response<List<LeagueInfoDto>> =
        leagueService.fetchLeagues(leagueId)

    suspend fun fetchLeagues(teamId: Int, season: Int): Response<List<LeagueInfoDto>> =
        leagueService.fetchLeagues(teamId, season)
}
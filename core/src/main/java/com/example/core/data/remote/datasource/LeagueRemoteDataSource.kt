package com.example.core.data.remote.datasource

import com.example.core.data.remote.model.response.Response
import com.example.core.data.remote.model.statistics.LeagueInfoDto
import com.example.core.di.NetworkModule.provideRetrofit
import com.example.core.di.NetworkModule.providesLeagueService
import javax.inject.Inject

class LeagueRemoteDataSource @Inject constructor(
) {
    suspend fun fetchLeagues(leagueId: Int): Response<List<LeagueInfoDto>> =
        providesLeagueService(provideRetrofit()).fetchLeagues(leagueId)

    suspend fun fetchLeagues(teamId: Int, season: Int): Response<List<LeagueInfoDto>> =
        providesLeagueService(provideRetrofit()).fetchLeagues(teamId, season)
}
package com.example.core.data.remote.datasource

import com.example.core.data.remote.model.response.Response
import com.example.core.data.remote.model.statistics.TeamStatisticsDto
import com.example.core.data.remote.model.teams.TeamInfoDto
import com.example.core.di.NetworkModule.provideRetrofit
import com.example.core.di.NetworkModule.providesTeamService
import javax.inject.Inject

class TeamRemoteDataSource @Inject constructor(
) {
    suspend fun fetchTeams(id: Int): Response<List<TeamInfoDto>> =
        providesTeamService(provideRetrofit()).fetchTeams(id)

    suspend fun fetchTeams(search: String): Response<List<TeamInfoDto>> =
        providesTeamService(provideRetrofit()).fetchTeams(search)

    suspend fun fetchTeams(league: Int, season: Int): Response<List<TeamInfoDto>> =
        providesTeamService(provideRetrofit()).fetchTeams(league, season)

    suspend fun fetchTeamStatistics(season: Int, teamId: Int, leagueId: Int): Response<TeamStatisticsDto> =
        providesTeamService(provideRetrofit()).fetchTeamStatistics(season, teamId, leagueId)
}
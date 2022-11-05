package com.example.core.data.remote.service

import com.example.core.data.remote.model.response.Response
import com.example.core.data.remote.model.statistics.TeamStatisticsDto
import com.example.core.data.remote.model.teams.TeamInfoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TeamService {
    @GET("teams")
    suspend fun fetchTeams(
        @Query("id") id: Int,
    ): Response<List<TeamInfoDto>>

    @GET("teams")
    suspend fun fetchTeams(
        @Query("search") search: String,
    ): Response<List<TeamInfoDto>>

    @GET("teams")
    suspend fun fetchTeams(
        @Query("league") league: Int,
        @Query("season") season: Int,
    ): Response<List<TeamInfoDto>>

    @GET("teams/statistics")
    suspend fun fetchTeamStatistics(
        @Query("season") season: Int,
        @Query("team") teamId: Int,
        @Query("league") leagueId: Int
    ): Response<TeamStatisticsDto>
}
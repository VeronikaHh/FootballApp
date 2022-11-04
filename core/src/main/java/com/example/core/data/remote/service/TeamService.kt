package com.example.core.data.remote.service

import com.example.core.data.remote.model.response.Response
import com.example.core.data.remote.model.statistics.TeamStatisticsDto
import com.example.core.data.remote.model.teams.TeamsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TeamService {
    @GET("teams")
    suspend fun fetchTeams(@Query("id") id: Int): Response<List<TeamsDto>>

    @GET("teams/statistics")
    suspend fun fetchTeamStatistics(
        @Query("season") season: Int,
        @Query("team") team: Int,
        @Query("league") league: Int
    ): Response<TeamStatisticsDto>
}
package com.example.core.data.remote.service

import com.example.core.data.remote.model.response.Response
import com.example.core.data.remote.model.statistics.TeamStatistics
import com.example.core.data.remote.model.teams.Teams
import retrofit2.http.GET
import retrofit2.http.Query

interface TeamService {
    @GET("teams")
    suspend fun fetchTeams(@Query("id") id: Int): Response<List<Teams>>

    @GET("teams/statistics")
    suspend fun fetchTeamStatistics(
        @Query("season") season: Int,
        @Query("team") team: Int,
        @Query("league") league: Int
    ): Response<TeamStatistics>
}
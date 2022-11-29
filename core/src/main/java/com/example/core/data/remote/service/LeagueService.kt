package com.example.core.data.remote.service

import com.example.core.data.remote.model.response.Response
import com.example.core.data.remote.model.statistics.LeagueInfoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface LeagueService {

    @GET("leagues")
    suspend fun fetchLeagues(
        @Query("id") leagueId: Int,
        ): Response<List<LeagueInfoDto>>

    @GET("leagues")
    suspend fun fetchLeagues(
        @Query("team") teamId: Int,
        @Query("season") season: Int = 2022,
    ): Response<List<LeagueInfoDto>>
}
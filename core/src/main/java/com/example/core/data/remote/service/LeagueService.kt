package com.example.core.data.remote.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LeagueService {

    @GET("leagues")
    suspend fun fetchLeagues(
        @Query("id") leagueId: Int,
        ): Response<List<???>>

    @GET("leagues")
    suspend fun fetchLeagues(
        @Query("team") teamId: Int,
        @Query("season") season: Int,
    ): Response<List<???>>
}
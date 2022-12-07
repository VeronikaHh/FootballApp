package com.example.core.data.remote.service

import com.example.core.data.remote.model.headToHead.HeadToHeadDto
import com.example.core.data.remote.model.response.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HeadToHeadService {
    @GET("fixtures/headtohead")
    suspend fun fetchHeadToHead(
        @Query("h2h") h2h: String,
    ): Response<List<HeadToHeadDto>>

    @GET("fixtures/headtohead")
    suspend fun fetchHeadToHeadThisSeason(
        @Query("h2h") h2h: String,
        @Query("season") season: String = "2022"
    ): Response<List<HeadToHeadDto>>

    @GET("fixtures/headtohead")
    suspend fun fetchHeadToHeadLastSeason(
        @Query("h2h") h2h: String,
        @Query("season") season: String = "2021"
    ): Response<List<HeadToHeadDto>>
}
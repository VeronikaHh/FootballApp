package com.example.core.data.remote.service

import com.example.core.data.remote.model.players.PlayerSquadDto
import com.example.core.data.remote.model.response.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PlayerService {
//    @GET("players")
//    suspend fun fetchPlayerDetails(
//        @Query("season") season: Int,
//        @Query("id") id: Int
//    ): Response<List<Any>>

    @GET("players/squads")
    suspend fun fetchPlayers(@Query("team") teamId: Int): Response<List<PlayerSquadDto>>
}
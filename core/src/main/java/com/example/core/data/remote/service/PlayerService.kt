package com.example.core.data.remote.service

import com.example.core.data.remote.model.players.PlayerSquadDto
import com.example.core.data.remote.model.response.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PlayerService {
    @GET("players/squads")
    suspend fun fetchPlayers(@Query("team") team: Int): Response<List<PlayerSquadDto>>
}
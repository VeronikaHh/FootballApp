package com.example.core.data.service

import com.example.core.data.model.remote.players.PlayerSquad
import com.example.core.data.model.remote.response.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PlayerService {
    @GET("players/squads")
    suspend fun fetchPlayers(@Query("team") team: Int): Response<List<PlayerSquad>>
}
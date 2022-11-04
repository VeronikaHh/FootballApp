package com.example.core.data.remote.datasource

import com.example.core.data.remote.model.players.PlayerSquadDto
import com.example.core.data.remote.model.response.Response
import com.example.core.data.remote.service.PlayerService

class PlayerRemoteDataSource(
    private val playerService: PlayerService,
) {
    suspend fun refreshPlayers(): Response<List<PlayerSquadDto>> =
        playerService.fetchPlayers(1)
}
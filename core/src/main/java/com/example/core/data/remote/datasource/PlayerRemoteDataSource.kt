package com.example.core.data.remote.datasource

import com.example.core.data.remote.model.players.PlayerSquad
import com.example.core.data.remote.model.response.Response
import com.example.core.data.remote.service.PlayerService
import kotlinx.coroutines.CoroutineDispatcher

class PlayerRemoteDataSource(
    private val playerService: PlayerService,
) {
    suspend fun refreshPlayers(): Response<List<PlayerSquad>> =
        playerService.fetchPlayers(1)
}
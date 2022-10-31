package com.example.core.data.datasource.remote

import com.example.core.data.model.remote.players.PlayerSquad
import com.example.core.data.model.remote.response.Response
import com.example.core.data.service.PlayerService
import kotlinx.coroutines.CoroutineDispatcher

class PlayerRemoteDataSource(
    private val playerService: PlayerService,
) {
    suspend fun refreshPlayers(): Response<List<PlayerSquad>> =
        playerService.fetchPlayers(1)
}
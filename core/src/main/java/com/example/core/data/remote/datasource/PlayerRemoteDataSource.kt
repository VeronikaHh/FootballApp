package com.example.core.data.remote.datasource

import com.example.core.data.remote.model.players.PlayerSquadDto
import com.example.core.data.remote.model.players.PlayerStatisticsDto
import com.example.core.data.remote.model.response.Response
import com.example.core.di.NetworkModule.provideRetrofit
import com.example.core.di.NetworkModule.providesPlayerService
import javax.inject.Inject

class PlayerRemoteDataSource @Inject constructor(
) {
    suspend fun fetchPlayers(teamId: Int): Response<List<PlayerSquadDto>> =
        providesPlayerService(provideRetrofit()).fetchPlayers(teamId)

    suspend fun fetchPlayerStatistics(id: Int, season: Int): Response<List<PlayerStatisticsDto>> =
        providesPlayerService(provideRetrofit()).fetchPlayerStatistics(id, season)
}
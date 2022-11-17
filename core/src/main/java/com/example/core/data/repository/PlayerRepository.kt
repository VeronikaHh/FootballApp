package com.example.core.data.repository

import com.example.core.data.mapper.PlayerSquadMapper
import com.example.core.data.remote.datasource.PlayerRemoteDataSource
import com.example.core.domain.model.PlayerSquad
import javax.inject.Inject

class PlayerRepository @Inject constructor(
    private val playerRemoteDataSource: PlayerRemoteDataSource,
    private val mapper: PlayerSquadMapper
){
    suspend fun getPlayerSquad(teamId: Int): PlayerSquad {
        val playerSquad = playerRemoteDataSource.fetchPlayers(
            teamId = teamId
        )
        return mapper.dtoToDomain(playerSquad.response[0])
    }
    suspend fun getPlayerStatistics(id: Int, season: Int) {
        val playerSquad = playerRemoteDataSource.fetchPlayerStatistics(
            id = id,
            season = 2022
        )
        //TODO: return domain  model (create domain model+player statistics mapper)
    }
}
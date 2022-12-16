package com.example.core.data.repository

import com.example.core.data.mapper.PlayerSquadMapper
import com.example.core.data.mapper.PlayerStatisticsMapper
import com.example.core.data.remote.datasource.PlayerRemoteDataSource
import com.example.core.domain.model.PlayerSquad
import com.example.core.domain.model.PlayerStatistics
import javax.inject.Inject

class PlayerRepository @Inject constructor(
    private val playerRemoteDataSource: PlayerRemoteDataSource,
    private val mapper: PlayerSquadMapper,
    private val statisticsMapper: PlayerStatisticsMapper
) {
    suspend fun getPlayerSquad(teamId: Int): PlayerSquad {
        val playerSquad = playerRemoteDataSource.fetchPlayers(
            teamId = teamId
        )
        return mapper.dtoToDomain(playerSquad.response[0])
    }

    suspend fun getPlayerStatistics(id: Int, team: Int): PlayerStatistics {
        val playerStatistics = playerRemoteDataSource.fetchPlayerStatistics(
            id = id,
            team = team
        )
        return statisticsMapper.dtoToDomain(playerStatistics.response[0])
    }
}
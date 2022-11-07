package com.example.core.data.repository

import com.example.core.data.local.database.dao.PlayerDao
import com.example.core.data.local.database.dao.PlayerSquadDao
import com.example.core.data.remote.datasource.PlayerRemoteDataSource
import com.example.core.domain.model.PlayerSquad
import com.example.core.domain.model.Team
import javax.inject.Inject

class PlayerRepository @Inject constructor(
    private val playerRemoteDataSource: PlayerRemoteDataSource,
){
    suspend fun getPlayerSquad(teamId: Int) {
        val playerSquad = playerRemoteDataSource.fetchPlayers(
            teamId = teamId
        )
    }
}

package com.example.core.data.local.datasource

import com.example.core.data.local.database.dao.PlayerDao
import com.example.core.data.local.database.dao.PlayerSquadDao
import com.example.core.data.local.database.dao.PlayerStatisticsDao
import javax.inject.Inject

class PlayerLocalDataSource @Inject constructor(
    private val playerDao: PlayerDao,
    private val playerSquadDao: PlayerSquadDao,
    private val playerStatisticsDao: PlayerStatisticsDao
){
}
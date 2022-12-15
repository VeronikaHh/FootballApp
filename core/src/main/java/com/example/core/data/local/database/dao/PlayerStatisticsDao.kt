package com.example.core.data.local.database.dao

import androidx.room.*
import com.example.core.data.local.model.PlayerEntity
import com.example.core.data.local.model.PlayerSquadEntity
import com.example.core.data.local.model.PlayerStatisticsEntity

interface PlayerStatisticsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(playerStatisticsEntity: PlayerStatisticsEntity)

    @Update
    fun update(playerStatisticsEntity: PlayerStatisticsEntity)

    @Delete
    fun delete(playerStatisticsEntity: PlayerStatisticsEntity)

    @Query("SELECT * FROM PlayerStatisticsEntity")
    fun getAll(): List<PlayerStatisticsEntity>

    @Query("SELECT * FROM PlayerStatisticsEntity WHERE player Like player")
    fun getPlayerStatistics(player: PlayerEntity): PlayerSquadEntity
}
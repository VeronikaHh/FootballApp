package com.example.core.data.local.database.dao

import androidx.room.*
import com.example.core.data.local.model.PlayerEntity
import com.example.core.data.local.model.PlayerTransfersEntity

interface PlayerTransfersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(playerTransfers: PlayerTransfersEntity)

    @Update
    fun update(playerTransfers: PlayerTransfersEntity)

    @Delete
    fun delete(playerTransfers: PlayerTransfersEntity)

    @Query("SELECT * FROM PlayerTransfersEntity")
    fun getAll(): List<PlayerTransfersEntity>

    @Query("SELECT * FROM PlayerTransfersEntity WHERE player Like player")
    fun getPlayerTransfers(player: PlayerEntity): PlayerTransfersEntity
}
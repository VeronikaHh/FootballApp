package com.example.core.data.database.dao

import androidx.room.*
import com.example.core.data.database.entity.PlayerEntity
import com.example.core.data.database.entity.VenueEntity

interface PlayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(playerEntity: PlayerEntity)

    @Update
    fun update(playerEntity: PlayerEntity)

    @Delete
    fun delete(playerEntity: PlayerEntity)

    @Query("SELECT * FROM PlayerEntity")
    fun getAll(): List<PlayerEntity>

    @Query("SELECT * FROM PlayerEntity WHERE id Like id")
    fun getPlayerById(id: Int): PlayerEntity
}
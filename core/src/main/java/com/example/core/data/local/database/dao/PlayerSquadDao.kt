package com.example.core.data.local.database.dao

import androidx.room.*
import com.example.core.data.local.model.PlayerEntity
import com.example.core.data.local.model.PlayerSquadEntity
import com.example.core.data.local.model.TeamEntity

interface PlayerSquadDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(playerSquadEntity: PlayerSquadEntity)

    @Update
    fun update(playerSquadEntity: PlayerSquadEntity)

    @Delete
    fun delete(playerSquadEntity: PlayerSquadEntity)

    @Query("SELECT * FROM PlayerSquadEntity")
    fun getAll(): List<PlayerEntity>

    @Query("SELECT * FROM PlayerSquadEntity WHERE team Like team")
    fun getPlayerSquadByTeam(team: TeamEntity): PlayerSquadEntity
}
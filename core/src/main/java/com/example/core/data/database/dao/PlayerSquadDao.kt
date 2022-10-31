package com.example.core.data.database.dao

import androidx.room.*
import com.example.core.data.database.entity.PlayerEntity
import com.example.core.data.database.entity.PlayerSquadEntity
import com.example.core.data.database.entity.TeamEntity

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
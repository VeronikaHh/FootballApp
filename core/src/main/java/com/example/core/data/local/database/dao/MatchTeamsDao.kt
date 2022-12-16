package com.example.core.data.local.database.dao

import androidx.room.*
import com.example.core.data.local.model.MatchTeamsEntity
import com.example.core.data.local.model.TeamsEntity

interface MatchTeamsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(matchTeamsEntity: MatchTeamsEntity)

    @Update
    fun update(matchTeamsEntity: MatchTeamsEntity)

    @Delete
    fun delete(matchTeamsEntity: MatchTeamsEntity)

    @Query("SELECT * FROM MatchTeamsEntity")
    fun getAll(): List<MatchTeamsEntity>

    @Query("SELECT * FROM MatchTeamsEntity WHERE home Like home AND away Like away")
    fun getLeagueInfo(home: TeamsEntity, away: TeamsEntity): MatchTeamsEntity
}
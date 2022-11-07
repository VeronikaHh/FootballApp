package com.example.core.data.local.database.dao

import androidx.room.*
import com.example.core.data.local.model.LeagueEntity
import com.example.core.data.local.model.LeagueInfoEntity

interface LeagueInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(leagueInfoEntity: LeagueInfoEntity)

    @Update
    fun update(leagueInfoEntity: LeagueInfoEntity)

    @Delete
    fun delete(leagueInfoEntity: LeagueInfoEntity)

    @Query("SELECT * FROM LeagueInfoEntity")
    fun getAll(): List<LeagueInfoEntity>

    @Query("SELECT * FROM LeagueInfoEntity WHERE league Like league")
    fun getTeamById(league: LeagueEntity): LeagueInfoEntity
}
package com.example.core.data.database.dao

import androidx.room.*
import com.example.core.data.database.entity.LeagueEntity

@Dao
interface LeagueDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(leagueEntity: LeagueEntity)

    @Update
    fun update(leagueEntity: LeagueEntity)

    @Delete
    fun delete(leagueEntity: LeagueEntity)

    @Query("SELECT * FROM LeagueEntity")
    fun getAll(): List<LeagueEntity>

    @Query("SELECT * FROM LeagueEntity WHERE id Like id")
    fun getTeamById(id: Int): LeagueEntity
}
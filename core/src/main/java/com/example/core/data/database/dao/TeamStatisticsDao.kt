package com.example.core.data.database.dao

import androidx.room.*
import com.example.core.data.database.entity.TeamEntity
import com.example.core.data.database.entity.TeamStatisticsEntity

@Dao
interface TeamStatisticsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(teamStatisticsEntity: TeamStatisticsEntity)

    @Update
    fun update(teamStatisticsEntity: TeamStatisticsEntity)

    @Delete
    fun delete(teamStatisticsEntity: TeamStatisticsEntity)

    @Query("SELECT * FROM TeamStatisticsEntity")
    fun getAll(): List<TeamStatisticsEntity>

    @Query("SELECT * FROM TeamStatisticsEntity WHERE team Like team")
    fun getStatisticsByTeam(team: TeamEntity): TeamStatisticsEntity
}
package com.example.core.data.local.database.dao

import androidx.room.*
import com.example.core.data.local.model.TeamEntity
import com.example.core.data.local.model.TeamsEntity

@Dao
interface TeamsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(teamsEntity: TeamsEntity)

    @Update
    fun update(teamsEntity: TeamsEntity)

    @Delete
    fun delete(teamsEntity: TeamsEntity)

    @Query("SELECT * FROM TeamsEntity")
    fun getAll(): List<TeamsEntity>

    @Query("SELECT * FROM TeamsEntity WHERE team Like team")
    fun getStatisticsByTeam(team: TeamEntity): TeamsEntity
}
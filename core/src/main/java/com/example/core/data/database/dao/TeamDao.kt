package com.example.core.data.database.dao

import androidx.room.*
import com.example.core.data.database.entity.TeamEntity

@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(teamEntity: TeamEntity)

    @Update
    fun update(teamEntity: TeamEntity)

    @Delete
    fun delete(teamEntity: TeamEntity)

    @Query("SELECT * FROM TeamEntity")
    fun getAll(): List<TeamEntity>

    @Query("SELECT * FROM TeamEntity WHERE id Like id")
    fun getTeamById(id: Int): TeamEntity
}
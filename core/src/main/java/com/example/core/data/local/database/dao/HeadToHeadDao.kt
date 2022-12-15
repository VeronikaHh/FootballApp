package com.example.core.data.local.database.dao

import androidx.room.*
import com.example.core.data.local.model.HeadToHeadEntity
import com.example.core.data.local.model.MatchTeamsEntity

interface HeadToHeadDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(headEntity: HeadToHeadEntity)

    @Update
    fun update(headEntity: HeadToHeadEntity)

    @Delete
    fun delete(headEntity: HeadToHeadEntity)

    @Query("SELECT * FROM HeadToHeadEntity")
    fun getAll(): List<HeadToHeadEntity>

    @Query("SELECT * FROM HeadToHeadEntity WHERE teams Like teams")
    fun getHeadToHeadByTeams(teams: MatchTeamsEntity): HeadToHeadEntity
}
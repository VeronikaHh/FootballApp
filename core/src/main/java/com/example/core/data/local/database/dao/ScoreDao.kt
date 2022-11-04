package com.example.core.data.local.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.core.data.local.model.ScoreEntity

interface ScoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(scoreEntity: ScoreEntity)

    @Update
    fun update(scoreEntity: ScoreEntity)

    @Delete
    fun delete(scoreEntity: ScoreEntity)
}
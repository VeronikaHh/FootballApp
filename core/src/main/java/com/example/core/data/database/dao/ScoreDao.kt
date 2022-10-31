package com.example.core.data.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.core.data.database.entity.ScoreEntity
import com.example.core.data.database.entity.TotalAverageEntity

interface ScoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(scoreEntity: ScoreEntity)

    @Update
    fun update(scoreEntity: ScoreEntity)

    @Delete
    fun delete(scoreEntity: ScoreEntity)
}
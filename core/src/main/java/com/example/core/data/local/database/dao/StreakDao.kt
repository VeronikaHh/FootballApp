package com.example.core.data.local.database.dao

import androidx.room.*
import com.example.core.data.local.model.StreakEntity

@Dao
interface StreakDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(streakEntity: StreakEntity)

    @Update
    fun update(streakEntity: StreakEntity)

    @Delete
    fun delete(streakEntity: StreakEntity)
}
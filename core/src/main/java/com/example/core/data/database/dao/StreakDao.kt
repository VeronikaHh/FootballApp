package com.example.core.data.database.dao

import androidx.room.*
import com.example.core.data.database.entity.GoalsEntity
import com.example.core.data.database.entity.StreakEntity

@Dao
interface StreakDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(streakEntity: StreakEntity)

    @Update
    fun update(streakEntity: StreakEntity)

    @Delete
    fun delete(streakEntity: StreakEntity)
}
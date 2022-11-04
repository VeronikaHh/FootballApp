package com.example.core.data.local.database.dao

import androidx.room.*
import com.example.core.data.local.model.GoalsEntity

@Dao
interface GoalsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(goalsEntity: GoalsEntity)

    @Update
    fun update(goalsEntity: GoalsEntity)

    @Delete
    fun delete(goalsEntity: GoalsEntity)
}
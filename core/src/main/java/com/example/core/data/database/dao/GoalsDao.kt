package com.example.core.data.database.dao

import androidx.room.*
import com.example.core.data.database.entity.GoalsEntity
import com.example.core.data.model.remote.statistics.Fixtures

@Dao
interface GoalsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(goalsEntity: GoalsEntity)

    @Update
    fun update(goalsEntity: GoalsEntity)

    @Delete
    fun delete(goalsEntity: GoalsEntity)
}
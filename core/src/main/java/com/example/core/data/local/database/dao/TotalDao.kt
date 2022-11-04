package com.example.core.data.local.database.dao

import androidx.room.*
import com.example.core.data.local.model.TotalEntity

interface TotalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(totalEntity: TotalEntity)

    @Update
    fun update(totalEntity: TotalEntity)

    @Delete
    fun delete(totalEntity: TotalEntity)
}
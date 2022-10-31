package com.example.core.data.database.dao

import androidx.room.*
import com.example.core.data.database.entity.TotalEntity
import com.example.core.data.database.entity.VenueEntity

interface TotalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(totalEntity: TotalEntity)

    @Update
    fun update(totalEntity: TotalEntity)

    @Delete
    fun delete(totalEntity: TotalEntity)
}
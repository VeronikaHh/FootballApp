package com.example.core.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.core.data.local.model.TotalAverageEntity

@Dao
interface TotalAverageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(totalAverageEntity: TotalAverageEntity)

    @Update
    fun update(totalAverageEntity: TotalAverageEntity)

    @Delete
    fun delete(totalAverageEntity: TotalAverageEntity)
}
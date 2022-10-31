package com.example.core.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.core.data.database.entity.TotalAverageEntity
import com.example.core.data.database.entity.TotalEntity

@Dao
interface TotalAverageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(totalAverageEntity: TotalAverageEntity)

    @Update
    fun update(totalAverageEntity: TotalAverageEntity)

    @Delete
    fun delete(totalAverageEntity: TotalAverageEntity)
}
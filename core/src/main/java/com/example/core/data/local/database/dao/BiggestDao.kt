package com.example.core.data.local.database.dao

import androidx.room.*
import com.example.core.data.local.model.BiggestEntity

@Dao
interface BiggestDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(biggestEntity: BiggestEntity)

    @Update
    fun update(biggestEntity: BiggestEntity)

    @Delete
    fun delete(biggestEntity: BiggestEntity)
}
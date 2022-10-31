package com.example.core.data.database.dao

import androidx.room.*
import com.example.core.data.database.entity.BiggestEntity
import com.example.core.data.database.entity.TeamEntity

@Dao
interface BiggestDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(biggestEntity: BiggestEntity)

    @Update
    fun update(biggestEntity: BiggestEntity)

    @Delete
    fun delete(biggestEntity: BiggestEntity)
}
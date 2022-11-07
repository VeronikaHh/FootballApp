package com.example.core.data.local.database.dao

import androidx.room.*
import com.example.core.data.local.model.SeasonEntity

interface SeasonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(seasonEntity: SeasonEntity)

    @Update
    fun update(seasonEntity: SeasonEntity)

    @Delete
    fun delete(seasonEntity: SeasonEntity)

    @Query("SELECT * FROM SeasonEntity")
    fun getAll(): List<SeasonEntity>

    @Query("SELECT * FROM SeasonEntity WHERE year Like year")
    fun getSeasonByYear(year: Int): SeasonEntity
}
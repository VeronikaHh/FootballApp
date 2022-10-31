package com.example.core.data.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.core.data.database.entity.BiggestEntity
import com.example.core.data.model.remote.statistics.Fixtures

interface FixturesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(fixtures: Fixtures)

    @Update
    fun update(fixtures: Fixtures)

    @Delete
    fun delete(fixtures: Fixtures)
}
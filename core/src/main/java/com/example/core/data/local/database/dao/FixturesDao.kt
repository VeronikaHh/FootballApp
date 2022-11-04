package com.example.core.data.local.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.core.data.remote.model.statistics.Fixtures

interface FixturesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(fixtures: Fixtures)

    @Update
    fun update(fixtures: Fixtures)

    @Delete
    fun delete(fixtures: Fixtures)
}
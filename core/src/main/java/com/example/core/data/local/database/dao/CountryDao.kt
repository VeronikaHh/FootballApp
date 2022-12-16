package com.example.core.data.local.database.dao

import androidx.room.*
import com.example.core.data.local.model.CountryEntity

interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(countryEntity: CountryEntity)

    @Update
    fun update(countryEntity: CountryEntity)

    @Delete
    fun delete(countryEntity: CountryEntity)

    @Query("SELECT * FROM CountryEntity")
    fun getAll(): List<CountryEntity>

    @Query("SELECT * FROM CountryEntity WHERE name Like name")
    fun getCountryByName(name: String): CountryEntity
}
package com.example.core.data.local.database.dao

import androidx.room.*
import com.example.core.data.local.model.VenueEntity

interface VenueDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(venueEntity: VenueEntity)

    @Update
    fun update(venueEntity: VenueEntity)

    @Delete
    fun delete(venueEntity: VenueEntity)

    @Query("SELECT * FROM VenueEntity")
    fun getAll(): List<VenueEntity>

    @Query("SELECT * FROM VenueEntity WHERE id Like id")
    fun getVenueById(id: Int): VenueEntity
}
package com.example.core.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity//(tableName = "venue_table")
data class VenueEntity(
    @PrimaryKey
    val id: Int? = null,
    val address: String? = null,
    val capacity: Int? = null,
    val city: String? = null,
    val image: String? = null,
    val name: String? = null,
    val surface: String? = null
)
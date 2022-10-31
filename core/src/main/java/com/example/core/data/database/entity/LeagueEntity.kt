package com.example.core.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LeagueEntity(
    @PrimaryKey
    val id: Int? = null,
    val country: String? = null,
    val flag: String? = null,
    val logo: String? = null,
    val name: String? = null,
    val season: Int? = null
)
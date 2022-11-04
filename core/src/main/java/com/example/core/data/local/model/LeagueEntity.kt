package com.example.core.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity//(tableName = "league_table")
data class LeagueEntity(
    @PrimaryKey
    val id: Int? = null,
    val country: String? = null,
    val flag: String? = null,
    val logo: String? = null,
    val name: String? = null,
    val season: Int? = null
)

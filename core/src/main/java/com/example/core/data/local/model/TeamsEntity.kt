package com.example.core.data.local.model

import androidx.room.Entity

@Entity//(tableName = "teams_table")
data class TeamsEntity(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int,
    val team: TeamEntity? = null,
    val venue: VenueEntity? = null
)
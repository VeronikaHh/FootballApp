package com.example.core.data.database.entity

import androidx.room.Entity

@Entity
data class TeamsEntity(
    val team: TeamEntity? = null,
    val venue: VenueEntity? = null
)
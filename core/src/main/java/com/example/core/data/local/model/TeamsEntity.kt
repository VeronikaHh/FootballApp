package com.example.core.data.local.model

import androidx.room.Entity

@Entity
data class TeamsEntity(
    val team: TeamEntity? = null,
    val venue: VenueEntity? = null
)
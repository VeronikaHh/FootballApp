package com.example.core.data.local.model

import androidx.room.Entity

@Entity
data class PlayerSquadEntity(
    val team: TeamEntity? = null,
    val players: List<PlayerEntity>? = null
)
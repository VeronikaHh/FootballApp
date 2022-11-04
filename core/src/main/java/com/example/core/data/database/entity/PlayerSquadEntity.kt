package com.example.core.data.database.entity

import androidx.room.Entity

@Entity
data class PlayerSquadEntity(
    val team: TeamEntity? = null,
    val players: List<PlayerEntity>? = null
)
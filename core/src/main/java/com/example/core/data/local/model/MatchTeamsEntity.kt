package com.example.core.data.local.model

import androidx.room.Entity


@Entity
data class MatchTeamsEntity constructor(
    val home: TeamEntity? = null,
    val away: TeamEntity? = null
)
package com.example.core.data.local.model

import androidx.room.Entity

@Entity
data class ScoreEntity(
    val away: String? = null,
    val home: String? = null
)

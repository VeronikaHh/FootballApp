package com.example.core.data.database.entity

import androidx.room.Entity

@Entity
data class StreakEntity(
    val draws: Int? = null,
    val loses: Int? = null,
    val wins: Int? = null
)

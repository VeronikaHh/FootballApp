package com.example.core.data.database.entity

import androidx.room.Entity

@Entity
data class BiggestEntity(
    val loses: ScoreEntity? = null,
    val streak: StreakEntity? = null,
    val wins: ScoreEntity? = null
)

package com.example.core.data.database.entity

import androidx.room.Entity

@Entity
data class BiggestEntity(
    val loses: TotalEntity? = null,
    val streak: StreakEntity? = null,
    val wins: TotalEntity? = null
)

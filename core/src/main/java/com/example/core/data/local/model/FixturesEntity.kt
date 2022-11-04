package com.example.core.data.local.model

import androidx.room.Entity

@Entity
data class FixturesEntity(
    val draws: TotalEntity? = null,
    val loses: TotalEntity? = null,
    val played: TotalEntity? = null,
    val wins: TotalEntity? = null
)

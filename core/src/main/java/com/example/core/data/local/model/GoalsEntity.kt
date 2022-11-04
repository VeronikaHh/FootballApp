package com.example.core.data.local.model

import androidx.room.Entity

@Entity
data class GoalsEntity(
    val against: TotalAverageEntity? = null,
    val `for`: TotalAverageEntity? = null
)

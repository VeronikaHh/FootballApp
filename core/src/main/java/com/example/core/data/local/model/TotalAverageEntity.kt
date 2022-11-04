package com.example.core.data.local.model

import androidx.room.Entity

@Entity
data class TotalAverageEntity(
    val total: TotalEntity? = null,
    val average: TotalEntity? = null
)
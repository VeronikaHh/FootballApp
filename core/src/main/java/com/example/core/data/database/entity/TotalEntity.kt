package com.example.core.data.database.entity

import androidx.room.Entity

@Entity
data class TotalEntity(
    val away: Double? = null,
    val home: Double? = null,
    val total: Double? = null
)

package com.example.core.data.database.entity

import androidx.room.Entity
import com.example.core.data.model.remote.statistics.Total
import com.example.core.data.model.remote.statistics.TotalAverage

@Entity
data class TotalAverageEntity(
    val total: Total? = null,
    val average: Total? = null
)
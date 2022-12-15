package com.example.core.data.local.model

import androidx.room.Entity

@Entity
data class PlayerStatisticsEntity(
    //@PrimaryKey
    // var id: Int
    var player: PlayerEntity? = null,
    var statistics: String? = null
)

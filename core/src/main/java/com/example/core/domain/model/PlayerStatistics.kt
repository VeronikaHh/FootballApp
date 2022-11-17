package com.example.core.domain.model


data class PlayerStatistics(
    var player: Player? = null,
    val statistics: List<Statistics>? = null
)

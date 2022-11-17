package com.example.core.data.remote.model.players

data class PlayerStatisticsDto(
    val player: PlayerDto? = null,
    val statistics: List<StatisticsDto>? = null
)
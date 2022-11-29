package com.example.core.domain.model

data class PlayerFragmentData(
    val transfer: PlayerTransfers ?= null,
    var player: Player? = null,
    val statistics: Statistics? = null
)
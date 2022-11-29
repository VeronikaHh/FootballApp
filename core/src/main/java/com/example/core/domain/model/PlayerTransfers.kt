package com.example.core.domain.model

data class PlayerTransfers(
    val player: Player?= null,
    val transfers: List<Transfer> ?=null
)

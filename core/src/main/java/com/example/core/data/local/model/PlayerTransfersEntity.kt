package com.example.core.data.local.model

data class PlayerTransfersEntity(
    val player: PlayerEntity? = null,
    val transfers: List<TransferEntity>? = null
)
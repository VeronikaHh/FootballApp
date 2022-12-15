package com.example.core.data.local.model

import androidx.room.Entity

@Entity
data class PlayerTransfersEntity(
    val player: PlayerEntity? = null,
    val transfers: List<TransferEntity>? = null
)
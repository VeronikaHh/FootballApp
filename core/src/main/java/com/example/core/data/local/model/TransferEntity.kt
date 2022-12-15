package com.example.core.data.local.model

import androidx.room.Entity

@Entity
data class TransferEntity(
    val date: String? = null,
    val type: String? = null,
    val teams: TransferTeamEntity? = null
)
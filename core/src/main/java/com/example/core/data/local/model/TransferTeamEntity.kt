package com.example.core.data.local.model

import androidx.room.Entity


@Entity
data class TransferTeamEntity(
    val inTeam: TeamEntity? = null,
    val outTeam: TeamEntity? = null
)
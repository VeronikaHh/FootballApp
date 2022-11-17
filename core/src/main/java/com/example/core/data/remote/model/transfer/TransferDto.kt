package com.example.core.data.remote.model.transfer

data class TransferDto(
    val date: String? = null,
    val type: String? = null,
    val teams: TransferTeamDto? = null
)

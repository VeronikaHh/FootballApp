package com.example.core.domain.model

data class Transfer(
    val date: String? = null,
    val type: String? = null,
    val teams: List<TransferTeam>? = null
)

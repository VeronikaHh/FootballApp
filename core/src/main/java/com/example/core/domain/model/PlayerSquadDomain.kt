package com.example.core.domain.model

data class PlayerSquadDomain(
    val team: TeamDomain? = null,
    val players: List<PlayerDomain>? = null
)

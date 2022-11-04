package com.example.core.data.remote.model.players

import com.example.core.data.remote.model.teams.TeamDto

data class PlayerSquadDto(
    val team: TeamDto? = null,
    val players: List<PlayerDto>? = null
)
package com.example.core.data.remote.model.players

import com.example.core.data.remote.model.teams.Team

data class PlayerSquad(
    val team: Team? = null,
    val players: List<Player>? = null
)
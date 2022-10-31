package com.example.core.data.model.remote.players

import com.example.core.data.model.remote.teams.Team

data class PlayerSquad(
    val team: Team? = null,
    val players: List<Player>? = null
)
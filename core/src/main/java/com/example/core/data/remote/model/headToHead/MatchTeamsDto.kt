package com.example.core.data.remote.model.headToHead

import com.example.core.data.remote.model.teams.TeamDto

data class MatchTeamsDto(
    val home: TeamDto? = null,
    val away: TeamDto? = null
)
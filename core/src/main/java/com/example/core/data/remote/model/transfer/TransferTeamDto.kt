package com.example.core.data.remote.model.transfer

import com.example.core.data.remote.model.teams.TeamDto

data class TransferTeamDto(
    val `in`: TeamDto? = null,
    val `out`: TeamDto? = null
)
package com.example.core.data.local.model

import androidx.room.Entity

@Entity
data class HeadToHeadEntity(
    val fixture: String? = null,
    val league: LeagueEntity? = null,
    val teams: MatchTeamsEntity? = null,
    val goals: String? = null,
    val score: String? = null
)
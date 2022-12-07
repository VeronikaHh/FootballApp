package com.example.core.domain.model


data class HeadToHead(
    val fixture: Fixture? = null,
    val league: League? = null,
    val teams: MatchTeams? = null,
    val goals: Score? = null,
    val score: MatchScore? = null
)

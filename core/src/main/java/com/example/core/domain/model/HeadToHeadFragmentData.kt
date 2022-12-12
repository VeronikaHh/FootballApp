package com.example.core.domain.model

data class HeadToHeadFragmentData(
    val lastTen: List<HeadToHead>? = null,
    val thisSeason: List<HeadToHead>? = null,
    val lastSeason: List<HeadToHead>? = null,
    val teams: MatchTeams? = null,
    val homeVenue: Venue? = null,
    val awayVenue: Venue? = null
)

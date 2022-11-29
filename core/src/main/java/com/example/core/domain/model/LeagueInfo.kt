package com.example.core.domain.model

data class LeagueInfo(
    var league: League? = null,
    var country: Country? = null,
    var seasons: List<Season>? = null
)

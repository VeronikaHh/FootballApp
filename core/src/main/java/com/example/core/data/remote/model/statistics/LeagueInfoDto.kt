package com.example.core.data.remote.model.statistics

data class LeagueInfoDto(
    var league: LeagueDto? = null,
    var country: CountryDto? = null,
    var seasons: List<SeasonDto>? = null
)
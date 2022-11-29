package com.example.core.data.local.model

import androidx.room.Entity


@Entity
data class LeagueInfoEntity(
    var league: LeagueEntity? = null,
    var country: CountryEntity? = null,
    var seasons: List<SeasonEntity>? = null
)

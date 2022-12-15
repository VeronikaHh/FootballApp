package com.example.core.data.local.model

import androidx.room.Entity


@Entity
data class LeagueInfoEntity(
    var league: LeagueEntity? = null,
    var country: CountryEntity? = null,
    //maybe better it be just string
    var seasons: List<SeasonEntity>? = null
)

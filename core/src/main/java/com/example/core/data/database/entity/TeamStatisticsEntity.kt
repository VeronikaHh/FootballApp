package com.example.core.data.database.entity

import androidx.room.Entity

@Entity
data class TeamStatisticsEntity(
    val biggest: BiggestEntity? = null,
    val clean_sheet: TotalEntity? = null,
    val fixtures: FixturesEntity? = null,
    val form: String? = null,
    val goals: GoalsEntity? = null,
    val league: LeagueEntity? = null,
    val team: TeamEntity? = null
)

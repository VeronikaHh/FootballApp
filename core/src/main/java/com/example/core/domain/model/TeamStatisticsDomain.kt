package com.example.core.domain.model


data class TeamStatisticsDomain(
    val biggest: BiggestDomain? = null,
    val clean_sheet: TotalDomain? = null,
    val fixtures: FixturesDomain? = null,
    val form: String? = null,
    val goals: GoalsDomain? = null,
    val league: LeagueDomain? = null,
    val team: TeamDomain? = null
)
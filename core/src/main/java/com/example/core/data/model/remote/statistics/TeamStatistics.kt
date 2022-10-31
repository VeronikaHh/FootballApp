package com.example.core.data.model.remote.statistics

import com.example.core.data.model.remote.teams.Team

data class TeamStatistics(
    val biggest: Biggest? = null,
    val clean_sheet: Total? = null,
    val fixtures: Fixtures? = null,
    val form: String? = null,
    val goals: Goals? = null,
    val league: League? = null,
    val team: Team? = null
)
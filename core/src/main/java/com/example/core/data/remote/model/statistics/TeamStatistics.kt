package com.example.core.data.remote.model.statistics

import com.example.core.data.remote.model.teams.Team

data class TeamStatistics(
    val biggest: Biggest? = null,
    val clean_sheet: Total? = null,
    val fixtures: Fixtures? = null,
    val form: String? = null,
    val goals: Goals? = null,
    val league: League? = null,
    val team: Team? = null
)
package com.example.core.data.remote.model.headToHead

import com.example.core.data.remote.model.statistics.LeagueDto
import com.example.core.data.remote.model.statistics.ScoreDto

data class HeadToHeadDto(
    val fixture: FixtureDto? = null,
    val league: LeagueDto? = null,
    val teams: MatchTeamsDto? = null,
    val goals: ScoreDto? = null,
    val score: MatchScoreDto? = null
)

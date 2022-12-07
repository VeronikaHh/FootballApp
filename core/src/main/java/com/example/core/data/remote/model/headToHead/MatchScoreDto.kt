package com.example.core.data.remote.model.headToHead

import com.example.core.data.remote.model.statistics.ScoreDto
import com.example.core.data.remote.model.statistics.dtoToDomain
import com.example.core.domain.model.MatchScore

data class MatchScoreDto(
    val halftime: ScoreDto?=null,
    val fulltime: ScoreDto?=null,
    val extratime: ScoreDto?=null,
    val penalty: ScoreDto?=null,
)

fun MatchScoreDto.dtoToDomain(): MatchScore {
    return MatchScore(
        halftime = this.halftime?.dtoToDomain(),
        fulltime = this.fulltime?.dtoToDomain(),
        extratime = this.extratime?.dtoToDomain(),
        penalty = this.penalty?.dtoToDomain()
    )
}
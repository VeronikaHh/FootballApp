package com.example.core.domain.model

data class BiggestDomain(
    val loses: ScoreDomain? = null,
    val streak: StreakDomain? = null,
    val wins: ScoreDomain? = null
)

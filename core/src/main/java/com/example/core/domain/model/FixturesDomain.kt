package com.example.core.domain.model

data class FixturesDomain(
    val draws: TotalDomain? = null,
    val loses: TotalDomain? = null,
    val played: TotalDomain? = null,
    val wins: TotalDomain? = null
)

package com.example.core.domain.model

data class Team(
    val id: Int? = null,
    val code: String? = null,
    val country: String? = null,
    val founded: Int? = null,
    val logo: String? = null,
    val name: String? = null,
    val national: Boolean? = null,
    val statistics: TeamStatistics? = null
)

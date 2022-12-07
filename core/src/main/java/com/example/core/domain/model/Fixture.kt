package com.example.core.domain.model

data class Fixture(
    val id: Int? = null,
    val referee: String? = null,
    val timezone: String? = null,
    val date: String? = null,
    val timestamp: Int? = null,
    val periods: Periods? = null,
    val venue: Venue? = null,
    val status: Status? = null
)
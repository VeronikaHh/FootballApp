package com.example.core.domain.model


data class GoalsDomain(
    val against: TotalAverageDomain? = null,
    val `for`: TotalAverageDomain? = null
)
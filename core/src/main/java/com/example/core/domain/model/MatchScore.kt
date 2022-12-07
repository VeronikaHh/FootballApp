package com.example.core.domain.model

data class MatchScore(
    val halftime: Score?=null,
    val fulltime: Score?=null,
    val extratime: Score?=null,
    val penalty: Score?=null,
)

package com.example.core.data.local.model

import androidx.room.Entity

@Entity
data class SeasonEntity(
    var year: Int? = null,
    var start: String? = null,
    var end: String? = null,
    var current: Boolean? = null
)

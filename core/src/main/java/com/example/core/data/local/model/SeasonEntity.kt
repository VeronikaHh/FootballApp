package com.example.core.data.local.model

import androidx.room.Entity

//maybe better to delete this entity?
@Entity
data class SeasonEntity(
    var year: Int? = null,
    var start: String? = null,
    var end: String? = null,
    var current: Boolean? = null
)

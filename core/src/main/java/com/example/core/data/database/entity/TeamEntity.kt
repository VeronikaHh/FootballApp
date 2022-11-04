package com.example.core.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class TeamEntity constructor(
    @PrimaryKey
    val id: Int? = null,
    val code: String? = null,
    val country: String? = null,
    val founded: Int? = null,
    val logo: String? = null,
    val name: String? = null,
    val national: Boolean? = null
)
package com.example.core.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity//(tableName = "player_table")
data class PlayerEntity(
    @PrimaryKey
    val id: Int?,
    val age: Int? = null,
    val name: String? = null,
    val firstname: String? = null,
    val lastname: String? = null,
    val number: Int? = null,
    val photo: String? = null,
    val position: String? = null
)
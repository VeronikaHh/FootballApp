package com.example.core.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlayerEntity constructor(
    @PrimaryKey
    val id: Int? = null,
    val age: Int? = null,
    val name: String? = null,
    val number: Int? = null,
    val photo: String? = null,
    val position: String? = null,
)
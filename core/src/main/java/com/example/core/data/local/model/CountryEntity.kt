package com.example.core.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CountryEntity(
    @PrimaryKey
    var name: String? = null,
    var code: String? = null,
    var flag: String? = null
)
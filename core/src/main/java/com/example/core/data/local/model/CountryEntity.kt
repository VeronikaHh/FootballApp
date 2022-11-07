package com.example.core.data.local.model

import androidx.room.Entity

@Entity
data class CountryEntity(
    var name: String? = null,
    var code: String? = null,
    var flag: String? = null
)
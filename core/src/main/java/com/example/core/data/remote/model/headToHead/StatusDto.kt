package com.example.core.data.remote.model.headToHead

import com.example.core.domain.model.Status

data class StatusDto(
    val long: String? = null,
    val short: String? = null,
    val elapsed: String? = null
)

fun StatusDto.dtoToDomain(): Status {
    return Status(
        long = this.long,
        short = this.short,
        elapsed = this.elapsed
    )
}


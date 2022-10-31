package com.example.core.data.model.remote.response

data class Response<T>(
    val errors: List<Any>,
    val parameters: Parameters,
    val response: T,
    val results: Int
)

package com.example.core.data.remote.model.response

data class Response<T>(
    val errors: List<Any>,
    val parameters: Parameters,
    val response: T,
    val results: Int
)

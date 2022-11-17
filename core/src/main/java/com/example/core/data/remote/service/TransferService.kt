package com.example.core.data.remote.service

import com.example.core.data.remote.model.response.Response
import com.example.core.data.remote.model.transfer.PlayerTransfersDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TransferService {
    @GET("transfers")
    suspend fun fetchPlayerTransfers(@Query("player") player: Int): Response<List<PlayerTransfersDto>>
}
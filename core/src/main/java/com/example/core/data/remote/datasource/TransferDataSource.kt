package com.example.core.data.remote.datasource

import com.example.core.data.remote.model.response.Response
import com.example.core.data.remote.model.transfer.PlayerTransfersDto
import com.example.core.di.NetworkModule.provideRetrofit
import com.example.core.di.NetworkModule.providesTransferService
import javax.inject.Inject

class TransferDataSource @Inject constructor(
) {
    suspend fun fetchPlayerTransfers(player: Int): Response<List<PlayerTransfersDto>> =
        providesTransferService(provideRetrofit()).fetchPlayerTransfers(player)
}
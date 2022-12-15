package com.example.core.data.repository

import com.example.core.data.mapper.PlayerTransfersMapper
import com.example.core.data.remote.datasource.TransferDataSource
import com.example.core.domain.model.PlayerTransfers
import javax.inject.Inject

class TransferRepository @Inject constructor(
    private val transferDataSource: TransferDataSource,
    private val mapper: PlayerTransfersMapper
) {
    suspend fun getTransfers(player: Int): PlayerTransfers {
        val playerTransfers = transferDataSource.fetchPlayerTransfers(
            player = player
        )
        return mapper.dtoToDomain(playerTransfers.response[0])
    }
}
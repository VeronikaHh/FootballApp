package com.example.core.data.mapper

import com.example.core.data.local.model.PlayerTransfersEntity
import com.example.core.data.remote.model.transfer.PlayerTransfersDto
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.PlayerTransfers
import javax.inject.Inject

class PlayerTransfersMapper @Inject constructor(
    private val transferMapper: TransferMapper,
    private val playerMapper: PlayerMapper
) : Mapper<PlayerTransfersDto, PlayerTransfersEntity, PlayerTransfers> {
    override fun entityToDomain(entity: PlayerTransfersEntity): PlayerTransfers {
        return PlayerTransfers(
            player = entity.player?.let(playerMapper::entityToDomain),
            transfers = entity.transfers?.map(transferMapper::entityToDomain)
        )
    }

    override fun dtoToDomain(dto: PlayerTransfersDto): PlayerTransfers {
        return PlayerTransfers(
            player = dto.player?.let(playerMapper::dtoToDomain),
            transfers = dto.transfers?.map(transferMapper::dtoToDomain)
        )
    }

    override fun domainToEntity(domain: PlayerTransfers): PlayerTransfersEntity {
        return PlayerTransfersEntity(
            player = domain.player?.let(playerMapper::domainToEntity),
            transfers = domain.transfers?.map(transferMapper::domainToEntity)
        )
    }
}
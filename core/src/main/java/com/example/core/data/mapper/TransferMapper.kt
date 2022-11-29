package com.example.core.data.mapper

import com.example.core.data.local.model.TransferEntity
import com.example.core.data.remote.model.transfer.TransferDto
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.Transfer
import javax.inject.Inject

class TransferMapper @Inject constructor(
    private val transferTeamMapper: TransferTeamMapper
) : Mapper<TransferDto, TransferEntity, Transfer> {
    override fun entityToDomain(entity: TransferEntity): Transfer {
        return Transfer(
            date = entity.date,
            type = entity.type,
            teams = entity.teams?.let(transferTeamMapper::entityToDomain)
        )
    }

    override fun dtoToDomain(dto: TransferDto): Transfer {
        return Transfer(
            date = dto.date,
            type = dto.type,
            teams = dto.teams?.let(transferTeamMapper::dtoToDomain)
        )
    }

    override fun domainToEntity(domain: Transfer): TransferEntity {
        return TransferEntity(
            date = domain.date,
            type = domain.type,
            teams = domain.teams?.let(transferTeamMapper::domainToEntity)
        )
    }
}
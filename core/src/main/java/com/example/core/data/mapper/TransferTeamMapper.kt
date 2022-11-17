package com.example.core.data.mapper

import com.example.core.data.local.model.TransferTeamEntity
import com.example.core.data.remote.model.transfer.TransferTeamDto
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.TransferTeam
import javax.inject.Inject

class TransferTeamMapper @Inject constructor(
    private val teamMapper: TeamMapper
) : Mapper<TransferTeamDto, TransferTeamEntity, TransferTeam> {
    override fun entityToDomain(entity: TransferTeamEntity): TransferTeam {
        return TransferTeam(
            inTeam = entity.inTeam?.let(teamMapper::entityToDomain),
            outTeam = entity.outTeam?.let(teamMapper::entityToDomain)
        )
    }

    override fun dtoToDomain(dto: TransferTeamDto): TransferTeam {
        return TransferTeam(
            inTeam = dto.`in`?.let(teamMapper::dtoToDomain),
            outTeam = dto.`out`?.let(teamMapper::dtoToDomain)
        )
    }

    override fun domainToEntity(domain: TransferTeam): TransferTeamEntity {
        return TransferTeamEntity(
            inTeam = domain.inTeam?.let(teamMapper::domainToEntity),
            outTeam = domain.outTeam?.let(teamMapper::domainToEntity)
        )
    }
}
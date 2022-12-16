package com.example.core.data.mapper

import com.example.core.data.local.model.PlayerSquadEntity
import com.example.core.data.remote.model.players.PlayerSquadDto
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.PlayerSquad
import javax.inject.Inject

class PlayerSquadMapper @Inject constructor(
    private val teamMapper: TeamMapper,
    private val playerMapper: PlayerMapper
) : Mapper<PlayerSquadDto, PlayerSquadEntity, PlayerSquad> {
    override fun entityToDomain(entity: PlayerSquadEntity): PlayerSquad {
        return PlayerSquad(
            team = entity.team?.let(teamMapper::entityToDomain),
            players = entity.players?.map(playerMapper::entityToDomain)
        )
    }

    override fun dtoToDomain(dto: PlayerSquadDto): PlayerSquad {
        return PlayerSquad(
            team = dto.team?.let(teamMapper::dtoToDomain),
            players = dto.players?.map(playerMapper::dtoToDomain)
        )
    }

    override fun domainToEntity(domain: PlayerSquad): PlayerSquadEntity {
        return PlayerSquadEntity(
            team = domain.team?.let(teamMapper::domainToEntity),
            players = domain.players?.map(playerMapper::domainToEntity)
        )
    }
}
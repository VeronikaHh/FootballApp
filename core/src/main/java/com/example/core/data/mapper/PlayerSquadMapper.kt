package com.example.core.data.mapper

import com.example.core.data.local.model.PlayerSquadEntity
import com.example.core.data.remote.model.players.PlayerSquad
import com.example.core.di.MapperModule_ProvidePlayerMapperFactory.providePlayerMapper
import com.example.core.di.MapperModule_ProvideTeamMapperFactory.provideTeamMapper
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.PlayerSquadDomain
import javax.inject.Inject

class PlayerSquadMapper @Inject constructor() :
    Mapper<PlayerSquad, PlayerSquadEntity, PlayerSquadDomain> {
    override fun entityToDomain(entity: PlayerSquadEntity): PlayerSquadDomain {
        return PlayerSquadDomain(
            team = entity.team?.let { provideTeamMapper(MapperModule()).mapToDomain(it) },
            players = entity.players?.map {
                providePlayerMapper(MapperModule()).mapToDomain(it)
            }
        )
    }

    override fun dtoToDomain(dto: PlayerSquad): PlayerSquadDomain {
        return PlayerSquadDomain(
            team = dto.team?.let { provideTeamMapper(MapperModule()).map(it) },
            players = dto.players?.map {
                providePlayerMapper(MapperModule()).map(it)
            }
        )
    }

    override fun domainToEntity(domain: PlayerSquadDomain): PlayerSquadEntity {
        return PlayerSquadEntity(
            team = domain.team?.let { provideTeamMapper(MapperModule()).mapToEntity(it) },
            players = domain.players?.map {
                providePlayerMapper(MapperModule()).mapToEntity(it)
            }
        )
    }
}
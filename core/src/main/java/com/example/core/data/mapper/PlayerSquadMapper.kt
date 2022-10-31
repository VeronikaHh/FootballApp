package com.example.core.data.mapper

import com.example.core.data.database.entity.PlayerSquadEntity
import com.example.core.data.model.remote.players.PlayerSquad
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.PlayerSquadDomain

class PlayerSquadMapper(var teamMapper: TeamMapper, var playerMapper: PlayerMapper) :
    Mapper<PlayerSquad, PlayerSquadEntity, PlayerSquadDomain> {
    override fun mapToDomain(entity: PlayerSquadEntity): PlayerSquadDomain {
        return PlayerSquadDomain(
            team = teamMapper.mapToDomain(entity.team)
        )
    }

    override fun map(dto: PlayerSquad): PlayerSquadDomain {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(domain: PlayerSquadDomain): PlayerSquadEntity {
        TODO("Not yet implemented")
    }

}
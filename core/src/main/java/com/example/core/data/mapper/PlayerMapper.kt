package com.example.core.data.mapper

import com.example.core.data.local.model.PlayerEntity
import com.example.core.data.remote.model.players.Player
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.PlayerDomain
import javax.inject.Inject


class PlayerMapper @Inject constructor() : Mapper<Player, PlayerEntity, PlayerDomain> {

    override fun domainToEntity(domain: PlayerDomain): PlayerEntity {
        return PlayerEntity(
            id = domain.id,
            age = domain.age,
            name = domain.name,
            number = domain.number,
            photo = domain.photo,
            position = domain.position
        )
    }

    override fun entityToDomain(entity: PlayerEntity): PlayerDomain {
        return PlayerDomain(
            id = entity.id,
            age = entity.age,
            name = entity.name,
            number = entity.number,
            photo = entity.photo,
            position = entity.position
        )
    }

    override fun dtoToDomain(dto: Player): PlayerDomain {
        return PlayerDomain(
            id = dto.id,
            age = dto.age,
            name = dto.name,
            number = dto.number,
            photo = dto.photo,
            position = dto.position
        )
    }
}

package com.example.core.data.mapper

import com.example.core.data.local.model.PlayerEntity
import com.example.core.data.remote.model.players.PlayerDto
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.Player
import javax.inject.Inject


class PlayerMapper @Inject constructor() : Mapper<PlayerDto, PlayerEntity, Player> {

    override fun domainToEntity(domain: Player): PlayerEntity {
        return PlayerEntity(
            id = domain.id,
            age = domain.age,
            name = domain.name,
            number = domain.number,
            photo = domain.photo,
            position = domain.position
        )
    }

    override fun entityToDomain(entity: PlayerEntity): Player {
        return Player(
            id = entity.id,
            age = entity.age,
            name = entity.name,
            number = entity.number,
            photo = entity.photo,
            position = entity.position
        )
    }

    override fun dtoToDomain(dto: PlayerDto): Player {
        return Player(
            id = dto.id,
            age = dto.age,
            firstname = dto.firstname,
            lastname = dto.lastname,
            nationality = dto.nationality,
            height = dto.height,
            weight = dto.weight,
            name = dto.name,
            number = dto.number,
            photo = dto.photo,
            position = dto.position
        )
    }
}

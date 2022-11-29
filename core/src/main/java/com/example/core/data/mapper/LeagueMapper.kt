package com.example.core.data.mapper

import com.example.core.data.local.model.LeagueEntity
import com.example.core.data.remote.model.statistics.LeagueDto
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.League
import javax.inject.Inject

class LeagueMapper @Inject constructor() : Mapper<LeagueDto, LeagueEntity, League> {
    override fun entityToDomain(entity: LeagueEntity): League {
        return League(
            id = entity.id,
            country = entity.country,
            name = entity.name,
            flag = entity.flag,
            logo = entity.logo,
            type = entity.type,
            season = entity.season
        )
    }

    override fun dtoToDomain(dto: LeagueDto): League {
        return League(
            id = dto.id,
            country = dto.country,
            name = dto.name,
            flag = dto.flag,
            logo = dto.logo,
            type = dto.type,
            season = dto.season
        )
    }

    override fun domainToEntity(domain: League): LeagueEntity {
        return LeagueEntity(
            id = domain.id,
            country = domain.country,
            name = domain.name,
            flag = domain.flag,
            logo = domain.logo,
            type = domain.type,
            season = domain.season
        )
    }
}
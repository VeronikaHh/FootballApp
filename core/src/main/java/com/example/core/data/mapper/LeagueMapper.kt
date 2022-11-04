package com.example.core.data.mapper

import com.example.core.data.database.entity.LeagueEntity
import com.example.core.data.model.remote.statistics.League
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.LeagueDomain
import javax.inject.Inject

class LeagueMapper @Inject constructor() : Mapper<League, LeagueEntity, LeagueDomain> {
    override fun mapToDomain(entity: LeagueEntity): LeagueDomain {
        return LeagueDomain(
            id = entity.id,
            country = entity.country,
            name = entity.name,
            flag = entity.flag,
            logo = entity.logo,
            season = entity.season
        )
    }

    override fun map(dto: League): LeagueDomain {
        return LeagueDomain(
            id = dto.id,
            country = dto.country,
            name = dto.name,
            flag = dto.flag,
            logo = dto.logo,
            season = dto.season
        )
    }

    override fun mapToEntity(domain: LeagueDomain): LeagueEntity {
        return LeagueEntity(
            id = domain.id,
            country = domain.country,
            name = domain.name,
            flag = domain.flag,
            logo = domain.logo,
            season = domain.season
        )
    }

}
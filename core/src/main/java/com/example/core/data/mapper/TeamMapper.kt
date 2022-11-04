package com.example.core.data.mapper

import com.example.core.data.database.entity.TeamEntity
import com.example.core.data.model.remote.teams.Team
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.TeamDomain
import javax.inject.Inject

class TeamMapper @Inject constructor() : Mapper<Team, TeamEntity, TeamDomain> {
    override fun mapToDomain(entity: TeamEntity): TeamDomain {
        return TeamDomain(
            id = entity.id,
            code = entity.code,
            country = entity.country,
            founded = entity.founded,
            logo = entity.logo,
            name = entity.name,
            national = entity.national
        )
    }

    override fun map(dto: Team): TeamDomain {
        return TeamDomain(
            id = dto.id,
            code = dto.code,
            country = dto.country,
            founded = dto.founded,
            logo = dto.logo,
            name = dto.name,
            national = dto.national
        )
    }

    override fun mapToEntity(domain: TeamDomain): TeamEntity {
        return TeamEntity(
            id = domain.id,
            code = domain.code,
            country = domain.country,
            founded = domain.founded,
            logo = domain.logo,
            name = domain.name,
            national = domain.national
        )
    }
}
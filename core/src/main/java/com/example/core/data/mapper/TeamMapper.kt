package com.example.core.data.mapper

import com.example.core.data.local.model.TeamEntity
import com.example.core.data.remote.model.teams.TeamDto
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.Team
import com.example.core.domain.model.TeamStatistics
import com.google.gson.Gson
import javax.inject.Inject

class TeamMapper @Inject constructor(
    private val gson: Gson
) : Mapper<TeamDto, TeamEntity, Team> {
    override fun entityToDomain(entity: TeamEntity): Team {
        return Team(
            id = entity.id,
            code = entity.code,
            country = entity.country,
            founded = entity.founded,
            logo = entity.logo,
            name = entity.name,
            national = entity.national,
            statistics = entity.statistics?.let { data ->
                gson.fromJson(data, TeamStatistics::class.java)
            }
        )
    }

    override fun dtoToDomain(dto: TeamDto): Team {
        return Team(
            id = dto.id,
            code = dto.code,
            country = dto.country,
            founded = dto.founded,
            logo = dto.logo,
            name = dto.name,
            national = dto.national
        )
    }

    override fun domainToEntity(domain: Team): TeamEntity {
        return TeamEntity(
            id = domain.id,
            code = domain.code,
            country = domain.country,
            founded = domain.founded,
            logo = domain.logo,
            name = domain.name,
            national = domain.national,
            statistics = gson.toJson(domain.statistics)
        )
    }
}
package com.example.core.data.mapper

import com.example.core.data.local.model.MatchTeamsEntity
import com.example.core.data.remote.model.headToHead.MatchTeamsDto
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.MatchTeams
import javax.inject.Inject

class MatchTeamsMapper @Inject constructor(
    private val teamMapper: TeamMapper
) : Mapper<MatchTeamsDto, MatchTeamsEntity, MatchTeams> {
    override fun entityToDomain(entity: MatchTeamsEntity): MatchTeams {
        return MatchTeams(
            home = entity.home?.let(teamMapper::entityToDomain),
            away = entity.away?.let(teamMapper::entityToDomain)
        )
    }

    override fun dtoToDomain(dto: MatchTeamsDto): MatchTeams {
        return MatchTeams(
            home = dto.home?.let(teamMapper::dtoToDomain),
            away = dto.away?.let(teamMapper::dtoToDomain)
        )
    }

    override fun domainToEntity(domain: MatchTeams): MatchTeamsEntity {
        return MatchTeamsEntity(
            home = domain.home?.let(teamMapper::domainToEntity),
            away = domain.away?.let(teamMapper::domainToEntity)
        )
    }
}
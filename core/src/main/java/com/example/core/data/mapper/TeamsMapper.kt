package com.example.core.data.mapper

import com.example.core.data.local.model.TeamsEntity
import com.example.core.data.remote.model.teams.TeamInfoDto
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.Teams
import javax.inject.Inject

class TeamsMapper @Inject constructor(
    private val teamMapper: TeamMapper,
    private val venueMapper: VenueMapper
) : Mapper<TeamInfoDto, TeamsEntity, Teams> {
    override fun entityToDomain(entity: TeamsEntity): Teams {
        return Teams(
            team = entity.team?.let(teamMapper::entityToDomain),
            venue = entity.venue?.let(venueMapper::entityToDomain)
        )
    }

    override fun dtoToDomain(dto: TeamInfoDto): Teams {
        return Teams(
            team = dto.team?.let(teamMapper::dtoToDomain),
            venue = dto.venue?.let(venueMapper::dtoToDomain)
        )
    }

    override fun domainToEntity(domain: Teams): TeamsEntity {
        return TeamsEntity(
            team = domain.team?.let(teamMapper::domainToEntity),
            venue = domain.venue?.let(venueMapper::domainToEntity)
        )
    }
}
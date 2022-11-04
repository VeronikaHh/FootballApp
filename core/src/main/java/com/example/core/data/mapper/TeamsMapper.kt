package com.example.core.data.mapper

import com.example.core.data.local.model.TeamsEntity
import com.example.core.data.remote.model.teams.Teams
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.TeamsDomain
import javax.inject.Inject

class TeamsMapper @Inject constructor(
    private val teamMapper: TeamMapper,
    private val venueMapper: VenueMapper
) : Mapper<Teams, TeamsEntity, TeamsDomain> {
    override fun entityToDomain(entity: TeamsEntity): TeamsDomain {
        return TeamsDomain(
            team = entity.team?.let(teamMapper::entityToDomain),
            venue = entity.venue?.let(venueMapper::entityToDomain)
        )
    }

    override fun dtoToDomain(dto: Teams): TeamsDomain {
        return TeamsDomain(
            team = dto.team?.let(teamMapper::dtoToDomain),
            venue = dto.venue?.let(venueMapper::dtoToDomain)
        )
    }

    override fun domainToEntity(domain: TeamsDomain): TeamsEntity {
        return TeamsEntity(
            team = domain.team?.let(teamMapper::domainToEntity),
            venue = domain.venue?.let(venueMapper::domainToEntity)
        )
    }
}
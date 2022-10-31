package com.example.core.data.mapper

import com.example.core.data.database.entity.TeamsEntity
import com.example.core.data.model.remote.teams.Teams
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.TeamsDomain

class TeamsMapper(var teamMapper: TeamMapper, var venueMapper: VenueMapper) : Mapper<Teams, TeamsEntity, TeamsDomain> {
    override fun mapToDomain(entity: TeamsEntity): TeamsDomain {
        return TeamsDomain(
//            team = entity.team,
//            venue = entity.venue
        )
    }

    override fun map(dto: Teams): TeamsDomain {
        return TeamsDomain(
//            team = dto.team,
//            venue = dto.venue
        )
    }

    override fun mapToEntity(domain: TeamsDomain): TeamsEntity {
        return TeamsEntity(
//            team = domain.team,
//            venue = domain.venue
        )
    }
}
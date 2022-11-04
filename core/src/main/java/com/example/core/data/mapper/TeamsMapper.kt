package com.example.core.data.mapper

import com.example.core.data.database.entity.TeamsEntity
import com.example.core.data.model.remote.teams.Teams
import com.example.core.di.MapperModule
import com.example.core.di.MapperModule_ProvideTeamMapperFactory.provideTeamMapper
import com.example.core.di.MapperModule_ProvideVenueMapperFactory.provideVenueMapper
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.TeamsDomain
import javax.inject.Inject

class TeamsMapper @Inject constructor() : Mapper<Teams, TeamsEntity, TeamsDomain> {
    override fun mapToDomain(entity: TeamsEntity): TeamsDomain {
        return TeamsDomain(
            team = entity.team?.let { provideTeamMapper(MapperModule()).mapToDomain(entity.team) },
            venue = entity.venue?.let { provideVenueMapper(MapperModule()).mapToDomain(entity.venue) }
        )
    }

    override fun map(dto: Teams): TeamsDomain {
        return TeamsDomain(
            team = dto.team?.let { provideTeamMapper(MapperModule()).map(dto.team) },
            venue = dto.venue?.let { provideVenueMapper(MapperModule()).map(dto.venue) }
        )
    }

    override fun mapToEntity(domain: TeamsDomain): TeamsEntity {
        return TeamsEntity(
            team = domain.team?.let { provideTeamMapper(MapperModule()).mapToEntity(domain.team) },
            venue = domain.venue?.let { provideVenueMapper(MapperModule()).mapToEntity(domain.venue) }
        )
    }
}
package com.example.core.data.mapper

import com.example.core.data.local.model.FixturesEntity
import com.example.core.data.remote.model.statistics.Fixtures
import com.example.core.di.MapperModule_ProvideTotalMapperFactory.provideTotalMapper
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.FixturesDomain
import javax.inject.Inject

class FixturesMapper @Inject constructor() : Mapper<Fixtures, FixturesEntity, FixturesDomain> {
    override fun entityToDomain(entity: FixturesEntity): FixturesDomain {
        return FixturesDomain(
            draws = entity.draws?.let { provideTotalMapper(MapperModule()).mapToDomain(it) },
            loses = entity.loses?.let { provideTotalMapper(MapperModule()).mapToDomain(it) },
            played = entity.played?.let { provideTotalMapper(MapperModule()).mapToDomain(it) },
            wins = entity.wins?.let { provideTotalMapper(MapperModule()).mapToDomain(it) }
        )
    }

    override fun dtoToDomain(dto: Fixtures): FixturesDomain {
        return FixturesDomain(
            draws = dto.draws?.let { provideTotalMapper(MapperModule()).map(it) },
            loses = dto.loses?.let { provideTotalMapper(MapperModule()).map(it) },
            played = dto.played?.let { provideTotalMapper(MapperModule()).map(it) },
            wins = dto.wins?.let { provideTotalMapper(MapperModule()).map(it) }
        )
    }

    override fun domainToEntity(domain: FixturesDomain): FixturesEntity {
        return FixturesEntity(
            draws = domain.draws?.let { provideTotalMapper(MapperModule()).mapToEntity(it) },
            loses = domain.loses?.let { provideTotalMapper(MapperModule()).mapToEntity(it) },
            played = domain.played?.let { provideTotalMapper(MapperModule()).mapToEntity(it) },
            wins = domain.wins?.let { provideTotalMapper(MapperModule()).mapToEntity(it) }
        )
    }
}
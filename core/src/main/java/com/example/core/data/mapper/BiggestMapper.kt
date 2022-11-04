package com.example.core.data.mapper

import com.example.core.data.local.model.BiggestEntity
import com.example.core.data.remote.model.statistics.Biggest
import com.example.core.di.MapperModule_ProvideScoreMapperFactory.provideScoreMapper
import com.example.core.di.MapperModule_ProvideStreakMapperFactory.provideStreakMapper
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.BiggestDomain
import javax.inject.Inject

class BiggestMapper @Inject constructor() :
    Mapper<Biggest, BiggestEntity, BiggestDomain> {
    override fun entityToDomain(entity: BiggestEntity): BiggestDomain {
        return BiggestDomain(
            loses = entity.loses?.let { provideScoreMapper(MapperModule()).mapToDomain(it) },
            wins = entity.wins?.let { provideScoreMapper(MapperModule()).mapToDomain(it) },
            streak = entity.streak?.let { provideStreakMapper(MapperModule()).mapToDomain(it) }
        )
    }

    override fun dtoToDomain(dto: Biggest): BiggestDomain {
        return BiggestDomain(
            loses = dto.loses?.let { provideScoreMapper(MapperModule()).map(it) },
            wins = dto.wins?.let { provideScoreMapper(MapperModule()).map(it) },
            streak = dto.streak?.let { provideStreakMapper(MapperModule()).map(it) }
        )
    }

    override fun domainToEntity(domain: BiggestDomain): BiggestEntity {
        return BiggestEntity(
            loses = domain.loses?.let { provideScoreMapper(MapperModule()).mapToEntity(it) },
            wins = domain.wins?.let { provideScoreMapper(MapperModule()).mapToEntity(it) },
            streak = domain.streak?.let { provideStreakMapper(MapperModule()).mapToEntity(it) }
        )
    }
}
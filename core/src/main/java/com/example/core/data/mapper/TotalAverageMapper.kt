package com.example.core.data.mapper

import com.example.core.data.database.entity.TotalAverageEntity
import com.example.core.data.model.remote.statistics.TotalAverage
import com.example.core.di.MapperModule
import com.example.core.di.MapperModule_ProvideTotalMapperFactory.provideTotalMapper
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.TotalAverageDomain
import javax.inject.Inject

class TotalAverageMapper @Inject constructor() :
    Mapper<TotalAverage, TotalAverageEntity, TotalAverageDomain> {
    override fun mapToDomain(entity: TotalAverageEntity): TotalAverageDomain {
        return TotalAverageDomain(
            total = entity.total?.let { provideTotalMapper(MapperModule()).mapToDomain(entity.total) },
            average = entity.average?.let { provideTotalMapper(MapperModule()).mapToDomain(entity.average) }
        )
    }

    override fun map(dto: TotalAverage): TotalAverageDomain {
        return TotalAverageDomain(
            total = dto.total?.let { provideTotalMapper(MapperModule()).map(dto.total) },
            average = dto.average?.let { provideTotalMapper(MapperModule()).map(dto.average) }
        )
    }

    override fun mapToEntity(domain: TotalAverageDomain): TotalAverageEntity {
        return TotalAverageEntity(
            total = domain.total?.let { provideTotalMapper(MapperModule()).mapToEntity(domain.total) },
            average = domain.average?.let { provideTotalMapper(MapperModule()).mapToEntity(domain.average) }
        )
    }
}
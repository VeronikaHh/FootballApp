package com.example.core.data.mapper

import com.example.core.data.database.entity.TotalAverageEntity
import com.example.core.data.database.entity.TotalEntity
import com.example.core.data.model.remote.statistics.TotalAverage
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.TotalAverageDomain

class TotalAverageMapper(var totalMapper: TotalMapper): Mapper<TotalAverage, TotalAverageEntity, TotalAverageDomain> {
    override fun mapToDomain(entity: TotalAverageEntity): TotalAverageDomain {
        return TotalAverageDomain(
        )
    }

    override fun map(dto: TotalAverage): TotalAverageDomain {
        return TotalAverageDomain(
        )
    }

    override fun mapToEntity(domain: TotalAverageDomain): TotalAverageEntity {
        return TotalAverageEntity(
        )
    }
}
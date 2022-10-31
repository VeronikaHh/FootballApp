package com.example.core.data.mapper


import com.example.core.data.database.entity.TotalEntity
import com.example.core.data.model.remote.statistics.Total
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.TotalDomain


class TotalMapper : Mapper<Total, TotalEntity, TotalDomain> {
    override fun mapToDomain(entity: TotalEntity): TotalDomain {
        return TotalDomain(
            away = entity.away,
            home = entity.home,
            total = entity.total
        )
    }

    override fun map(dto: Total): TotalDomain {
        return TotalDomain(
            away = dto.away,
            home = dto.home,
            total = dto.total
        )
    }

    override fun mapToEntity(domain: TotalDomain): TotalEntity {
        return TotalEntity(
            away = domain.away,
            home = domain.home,
            total = domain.total
        )
    }
}
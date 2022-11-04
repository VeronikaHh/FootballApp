package com.example.core.data.mapper


import com.example.core.data.local.model.TotalEntity
import com.example.core.data.remote.model.statistics.Total
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.TotalDomain
import javax.inject.Inject


class TotalMapper @Inject constructor() : Mapper<Total, TotalEntity, TotalDomain> {
    override fun entityToDomain(entity: TotalEntity): TotalDomain {
        return TotalDomain(
            away = entity.away,
            home = entity.home,
            total = entity.total
        )
    }

    override fun dtoToDomain(dto: Total): TotalDomain {
        return TotalDomain(
            away = dto.away,
            home = dto.home,
            total = dto.total
        )
    }

    override fun domainToEntity(domain: TotalDomain): TotalEntity {
        return TotalEntity(
            away = domain.away,
            home = domain.home,
            total = domain.total
        )
    }
}
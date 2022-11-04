package com.example.core.data.mapper

import com.example.core.data.local.model.GoalsEntity
import com.example.core.data.remote.model.statistics.Goals
import com.example.core.di.MapperModule_ProvideTotalAverageMapperFactory.provideTotalAverageMapper
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.GoalsDomain
import javax.inject.Inject

class GoalsMapper @Inject constructor() : Mapper<Goals, GoalsEntity, GoalsDomain> {
    override fun entityToDomain(entity: GoalsEntity): GoalsDomain {
        return GoalsDomain(
            against = entity.against?.let { provideTotalAverageMapper(MapperModule()).mapToDomain(entity.against) },
            `for` = entity.`for`?.let { provideTotalAverageMapper(MapperModule()).mapToDomain(entity.`for`) }
        )
    }

    override fun dtoToDomain(dto: Goals): GoalsDomain {
        return GoalsDomain(
            against = dto.against?.let { provideTotalAverageMapper(MapperModule()).map(dto.against) },
            `for` = dto.`for`?.let { provideTotalAverageMapper(MapperModule()).map(dto.`for`) }
        )
    }

    override fun domainToEntity(domain: GoalsDomain): GoalsEntity {
        return GoalsEntity(
            against = domain.against?.let { provideTotalAverageMapper(MapperModule()).mapToEntity(domain.against) },
            `for` = domain.`for`?.let { provideTotalAverageMapper(MapperModule()).mapToEntity(domain.`for`) }
        )
    }
}
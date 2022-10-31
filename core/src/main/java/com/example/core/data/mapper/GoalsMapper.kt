package com.example.core.data.mapper

import com.example.core.data.database.entity.GoalsEntity
import com.example.core.data.model.remote.statistics.Goals
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.GoalsDomain

class GoalsMapper : Mapper<Goals, GoalsEntity, GoalsDomain> {
    override fun mapToDomain(entity: GoalsEntity): GoalsDomain {
        TODO("Not yet implemented")
    }

    override fun map(dto: Goals): GoalsDomain {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(domain: GoalsDomain): GoalsEntity {
        TODO("Not yet implemented")
    }
}
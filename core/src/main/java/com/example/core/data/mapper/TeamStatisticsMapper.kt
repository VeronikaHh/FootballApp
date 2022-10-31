package com.example.core.data.mapper

import com.example.core.data.database.entity.TeamStatisticsEntity
import com.example.core.data.model.remote.statistics.TeamStatistics
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.TeamStatisticsDomain

class TeamStatisticsMapper : Mapper<TeamStatistics, TeamStatisticsEntity, TeamStatisticsDomain> {
    override fun mapToDomain(entity: TeamStatisticsEntity): TeamStatisticsDomain {
        return TeamStatisticsDomain(

        )
    }

    override fun map(dto: TeamStatistics): TeamStatisticsDomain {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(domain: TeamStatisticsDomain): TeamStatisticsEntity {
        TODO("Not yet implemented")
    }
}
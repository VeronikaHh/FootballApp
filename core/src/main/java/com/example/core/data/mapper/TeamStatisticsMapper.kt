package com.example.core.data.mapper

import com.example.core.data.database.entity.TeamStatisticsEntity
import com.example.core.data.model.remote.statistics.TeamStatistics
import com.example.core.di.MapperModule
import com.example.core.di.MapperModule_ProvideBiggestMapperFactory.provideBiggestMapper
import com.example.core.di.MapperModule_ProvideFixturesMapperFactory.provideFixturesMapper
import com.example.core.di.MapperModule_ProvideGoalsMapperFactory.provideGoalsMapper
import com.example.core.di.MapperModule_ProvideLeagueMapperFactory.provideLeagueMapper
import com.example.core.di.MapperModule_ProvideTeamMapperFactory.provideTeamMapper
import com.example.core.di.MapperModule_ProvideTotalMapperFactory.provideTotalMapper
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.TeamStatisticsDomain
import javax.inject.Inject

class TeamStatisticsMapper @Inject constructor() :
    Mapper<TeamStatistics, TeamStatisticsEntity, TeamStatisticsDomain> {
    override fun mapToDomain(entity: TeamStatisticsEntity): TeamStatisticsDomain {
        return TeamStatisticsDomain(
            biggest = entity.biggest?.let { provideBiggestMapper(MapperModule()).mapToDomain(entity.biggest) },
            clean_sheet = entity.clean_sheet?.let {
                provideTotalMapper(MapperModule()).mapToDomain(
                    entity.clean_sheet
                )
            },
            fixtures = entity.fixtures?.let {
                provideFixturesMapper(MapperModule()).mapToDomain(
                    entity.fixtures
                )
            },
            form = entity.form,
            goals = entity.goals?.let { provideGoalsMapper(MapperModule()).mapToDomain(entity.goals) },
            league = entity.league?.let { provideLeagueMapper(MapperModule()).mapToDomain(entity.league) },
            team = entity.team?.let { provideTeamMapper(MapperModule()).mapToDomain(entity.team) }
        )
    }

    override fun map(dto: TeamStatistics): TeamStatisticsDomain {
        return TeamStatisticsDomain(
            biggest = dto.biggest?.let { provideBiggestMapper(MapperModule()).map(dto.biggest) },
            clean_sheet = dto.clean_sheet?.let { provideTotalMapper(MapperModule()).map(dto.clean_sheet) },
            fixtures = dto.fixtures?.let { provideFixturesMapper(MapperModule()).map(dto.fixtures) },
            form = dto.form,
            goals = dto.goals?.let { provideGoalsMapper(MapperModule()).map(dto.goals) },
            league = dto.league?.let { provideLeagueMapper(MapperModule()).map(dto.league) },
            team = dto.team?.let { provideTeamMapper(MapperModule()).map(dto.team) }
        )
    }

    override fun mapToEntity(domain: TeamStatisticsDomain): TeamStatisticsEntity {
        return TeamStatisticsEntity(
            biggest = domain.biggest?.let { provideBiggestMapper(MapperModule()).mapToEntity(domain.biggest) },
            clean_sheet = domain.clean_sheet?.let {
                provideTotalMapper(MapperModule()).mapToEntity(
                    domain.clean_sheet
                )
            },
            fixtures = domain.fixtures?.let {
                provideFixturesMapper(MapperModule()).mapToEntity(
                    domain.fixtures
                )
            },
            form = domain.form,
            goals = domain.goals?.let { provideGoalsMapper(MapperModule()).mapToEntity(domain.goals) },
            league = domain.league?.let { provideLeagueMapper(MapperModule()).mapToEntity(domain.league) },
            team = domain.team?.let { provideTeamMapper(MapperModule()).mapToEntity(domain.team) }
        )
    }
}
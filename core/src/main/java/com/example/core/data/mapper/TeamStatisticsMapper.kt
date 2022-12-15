package com.example.core.data.mapper

import com.example.core.data.local.model.TeamEntity
import com.example.core.data.remote.model.statistics.TeamStatisticsDto
import com.example.core.data.remote.model.statistics.dtoToDomain
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.TeamStatistics
import com.google.gson.Gson
import javax.inject.Inject

class TeamStatisticsMapper @Inject constructor(
    private val leagueMapper: LeagueMapper,
    private val teamMapper: TeamMapper,
    private val gson: Gson
) :
    Mapper<TeamStatisticsDto, TeamEntity, TeamStatistics> {
    override fun entityToDomain(entity: TeamEntity): TeamStatistics {
        return gson.fromJson(entity.statistics, TeamStatistics::class.java)
    }

    override fun dtoToDomain(dto: TeamStatisticsDto): TeamStatistics {
        return TeamStatistics(
            biggest = dto.biggest?.let { dto.biggest.dtoToDomain() },
            clean_sheet = dto.clean_sheet?.let { dto.clean_sheet.dtoToDomain() },
            fixtures = dto.fixtures?.let { dto.fixtures.dtoToDomain() },
            form = dto.form,
            goals = dto.goals?.let { dto.goals.dtoToDomain() },
            league = dto.league?.let(leagueMapper::dtoToDomain),
            team = dto.team?.let(teamMapper::dtoToDomain)
        )
    }

    override fun domainToEntity(domain: TeamStatistics): TeamEntity {
        return TeamEntity(
            id = domain.team?.id,
            code = domain.team?.code,
            country = domain.team?.country,
            founded = domain.team?.founded,
            logo = domain.team?.logo,
            name = domain.team?.name,
            national = domain.team?.national,
            statistics = gson.toJson(domain)
        )
    }
}
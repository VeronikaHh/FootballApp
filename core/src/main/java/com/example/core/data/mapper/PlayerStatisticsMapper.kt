package com.example.core.data.mapper

import com.example.core.data.local.model.PlayerStatisticsEntity
import com.example.core.data.remote.model.players.PlayerStatisticsDto
import com.example.core.data.remote.model.players.StatisticsDto
import com.example.core.data.remote.model.players.dtoToDomain
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.PlayerStatistics
import com.example.core.domain.model.Statistics
import com.google.gson.Gson
import javax.inject.Inject

class PlayerStatisticsMapper @Inject constructor(
    private val playerMapper: PlayerMapper,
    private val teamMapper: TeamMapper,
    private val leagueMapper: LeagueMapper,
    private val gson: Gson
) : Mapper<PlayerStatisticsDto,PlayerStatisticsEntity,PlayerStatistics> {
    override fun entityToDomain(entity: PlayerStatisticsEntity): PlayerStatistics {
        return PlayerStatistics(
            player = entity.player?.let(playerMapper::entityToDomain),
            statistics = gson.fromJson(entity.statistics, Statistics::class.java)
        )
    }

    override fun dtoToDomain(dto: PlayerStatisticsDto): PlayerStatistics {
        return PlayerStatistics(
            player = dto.player?.let(playerMapper::dtoToDomain),
            statistics = dto.statistics?.get(0)?.dtoToDomain(teamMapper, leagueMapper)
        )
    }

    override fun domainToEntity(domain: PlayerStatistics): PlayerStatisticsEntity {
        return PlayerStatisticsEntity(
            player = domain.player?.let(playerMapper::domainToEntity),
            statistics = gson.toJson(domain.statistics)
        )
    }
}
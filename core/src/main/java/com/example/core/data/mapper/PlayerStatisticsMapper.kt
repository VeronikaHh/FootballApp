package com.example.core.data.mapper

import com.example.core.data.local.model.PlayerStatisticsEntity
import com.example.core.data.remote.model.players.PlayerStatisticsDto
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.PlayerStatistics
import com.google.gson.Gson
import javax.inject.Inject

class PlayerStatisticsMapper @Inject constructor(
    private val playerMapper: PlayerMapper,
    private val teamMapper: TeamMapper,
    private val gson: Gson
) : Mapper<PlayerStatisticsDto,PlayerStatisticsEntity,PlayerStatistics> {
    override fun entityToDomain(entity: PlayerStatisticsEntity): PlayerStatistics {
        TODO("Not yet implemented")
    }

    override fun dtoToDomain(dto: PlayerStatisticsDto): PlayerStatistics {
        return PlayerStatistics(
            player = dto.player?.let(playerMapper::dtoToDomain),
            //TODO: map statistics
        )
    }

    override fun domainToEntity(domain: PlayerStatistics): PlayerStatisticsEntity {
        TODO("Not yet implemented")
    }
}
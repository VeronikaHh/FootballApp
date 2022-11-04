package com.example.core.data.mapper

import com.example.core.data.database.entity.StreakEntity
import com.example.core.data.model.remote.statistics.Streak
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.StreakDomain
import javax.inject.Inject

class StreakMapper @Inject constructor() : Mapper<Streak, StreakEntity, StreakDomain> {
    override fun mapToDomain(entity: StreakEntity): StreakDomain {
        return StreakDomain(
            draws = entity.draws,
            loses = entity.loses,
            wins = entity.wins
        )
    }

    override fun map(dto: Streak): StreakDomain {
        return StreakDomain(
            draws = dto.draws,
            loses = dto.loses,
            wins = dto.wins
        )
    }

    override fun mapToEntity(domain: StreakDomain): StreakEntity {
        return StreakEntity(
            draws = domain.draws,
            loses = domain.loses,
            wins = domain.wins
        )
    }
}
package com.example.core.data.mapper

import com.example.core.data.local.model.StreakEntity
import com.example.core.data.remote.model.statistics.Streak
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.StreakDomain
import javax.inject.Inject

class StreakMapper @Inject constructor() : Mapper<Streak, StreakEntity, StreakDomain> {
    override fun entityToDomain(entity: StreakEntity): StreakDomain {
        return StreakDomain(
            draws = entity.draws,
            loses = entity.loses,
            wins = entity.wins
        )
    }

    override fun dtoToDomain(dto: Streak): StreakDomain {
        return StreakDomain(
            draws = dto.draws,
            loses = dto.loses,
            wins = dto.wins
        )
    }

    override fun domainToEntity(domain: StreakDomain): StreakEntity {
        return StreakEntity(
            draws = domain.draws,
            loses = domain.loses,
            wins = domain.wins
        )
    }
}
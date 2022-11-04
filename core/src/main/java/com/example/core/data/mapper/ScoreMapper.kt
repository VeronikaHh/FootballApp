package com.example.core.data.mapper

import com.example.core.data.local.model.ScoreEntity
import com.example.core.data.remote.model.statistics.Score
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.ScoreDomain
import javax.inject.Inject

class ScoreMapper @Inject constructor() : Mapper<Score, ScoreEntity, ScoreDomain> {

    override fun entityToDomain(entity: ScoreEntity): ScoreDomain {
        return ScoreDomain(
            away = entity.away,
            home = entity.home
        )
    }

    override fun dtoToDomain(dto: Score): ScoreDomain {
        return ScoreDomain(
            away = dto.away,
            home = dto.home
        )
    }

    override fun domainToEntity(domain: ScoreDomain): ScoreEntity {
        return ScoreEntity(
            away = domain.away,
            home = domain.home
        )
    }
}
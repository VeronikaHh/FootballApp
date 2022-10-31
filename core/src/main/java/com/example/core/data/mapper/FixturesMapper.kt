package com.example.core.data.mapper

import com.example.core.data.database.entity.FixturesEntity
import com.example.core.data.model.remote.statistics.Fixtures
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.FixturesDomain

class FixturesMapper : Mapper<Fixtures, FixturesEntity, FixturesDomain> {
    override fun mapToDomain(entity: FixturesEntity): FixturesDomain {
        TODO("Not yet implemented")
    }

    override fun map(dto: Fixtures): FixturesDomain {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(domain: FixturesDomain): FixturesEntity {
        TODO("Not yet implemented")
    }
}
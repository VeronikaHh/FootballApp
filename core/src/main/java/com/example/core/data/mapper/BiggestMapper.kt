package com.example.core.data.mapper

import com.example.core.data.database.entity.BiggestEntity
import com.example.core.data.model.remote.statistics.Biggest
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.BiggestDomain

class BiggestMapper : Mapper<Biggest, BiggestEntity, BiggestDomain> {
    override fun mapToDomain(entity: BiggestEntity): BiggestDomain {
        TODO("Not yet implemented")
    }

    override fun map(dto: Biggest): BiggestDomain {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(domain: BiggestDomain): BiggestEntity {
        TODO("Not yet implemented")
    }
}
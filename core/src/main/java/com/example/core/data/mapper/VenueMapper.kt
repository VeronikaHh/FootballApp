package com.example.core.data.mapper

import com.example.core.data.local.model.VenueEntity
import com.example.core.data.remote.model.teams.Venue
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.VenueDomain
import javax.inject.Inject

class VenueMapper @Inject constructor(): Mapper<Venue, VenueEntity, VenueDomain> {
    override fun entityToDomain(entity: VenueEntity): VenueDomain {
        return VenueDomain(
            id = entity.id,
            address = entity.address,
            name = entity.name,
            capacity = entity.capacity,
            city = entity.city,
            image = entity.image,
            surface = entity.surface
        )
    }

    override fun dtoToDomain(dto: Venue): VenueDomain {
        return VenueDomain(
            id = dto.id,
            address = dto.address,
            name = dto.name,
            capacity = dto.capacity,
            city = dto.city,
            image = dto.image,
            surface = dto.surface
        )
    }

    override fun domainToEntity(domain: VenueDomain): VenueEntity {
        return VenueEntity(
            id = domain.id,
            address = domain.address,
            name = domain.name,
            capacity = domain.capacity,
            city = domain.city,
            image = domain.image,
            surface = domain.surface
        )
    }
}
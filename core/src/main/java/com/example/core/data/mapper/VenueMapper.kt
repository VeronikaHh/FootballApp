package com.example.core.data.mapper

import com.example.core.data.local.model.VenueEntity
import com.example.core.data.remote.model.teams.VenueDto
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.Venue
import javax.inject.Inject

class VenueMapper @Inject constructor(
) : Mapper<VenueDto, VenueEntity, Venue> {
    override fun entityToDomain(entity: VenueEntity): Venue {
        return Venue(
            id = entity.id,
            address = entity.address,
            name = entity.name,
            capacity = entity.capacity,
            city = entity.city,
            image = entity.image,
            surface = entity.surface
        )
    }

    override fun dtoToDomain(dto: VenueDto): Venue {
        return Venue(
            id = dto.id,
            address = dto.address,
            name = dto.name,
            capacity = dto.capacity,
            city = dto.city,
            image = dto.image,
            surface = dto.surface
        )
    }

    override fun domainToEntity(domain: Venue): VenueEntity {
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
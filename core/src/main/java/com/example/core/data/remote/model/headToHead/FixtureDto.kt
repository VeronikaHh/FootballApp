package com.example.core.data.remote.model.headToHead

import com.example.core.data.mapper.VenueMapper
import com.example.core.data.remote.model.teams.VenueDto
import com.example.core.domain.model.Fixture

data class FixtureDto(
    val id: Int? = null,
    val referee: String? = null,
    val timezone: String? = null,
    val date: String? = null,
    val timestamp: Int? = null,
    val periods: PeriodsDto? = null,
    val venue: VenueDto? = null,
    val status: StatusDto? = null
)

fun FixtureDto.dtoToDomain(venueMapper: VenueMapper): Fixture {
    return Fixture(
        id = this.id,
        referee = this.referee,
        timezone = this.timezone,
        date = this.date,
        timestamp = this.timestamp,
        periods = this.periods?.dtoToDomain(),
        venue = this.venue?.let(venueMapper::dtoToDomain),
        status = this.status?.dtoToDomain()
    )
}



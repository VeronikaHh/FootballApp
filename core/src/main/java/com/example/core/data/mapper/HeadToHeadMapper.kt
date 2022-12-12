package com.example.core.data.mapper

import com.example.core.data.local.model.HeadToHeadEntity
import com.example.core.data.remote.model.headToHead.HeadToHeadDto
import com.example.core.data.remote.model.headToHead.dtoToDomain
import com.example.core.data.remote.model.statistics.dtoToDomain
import com.example.core.domain.mapper.Mapper
import com.example.core.domain.model.*
import com.google.gson.Gson
import javax.inject.Inject

class HeadToHeadMapper @Inject constructor(
    private val venueMapper: VenueMapper,
    private val matchTeamsMapper: MatchTeamsMapper,
    private val leagueMapper: LeagueMapper,
    private val gson: Gson
): Mapper<HeadToHeadDto, HeadToHeadEntity, HeadToHead> {
    override fun entityToDomain(entity: HeadToHeadEntity): HeadToHead {
        return HeadToHead(
            fixture = gson.fromJson(entity.fixture, Fixture::class.java),
            league = entity.league?.let(leagueMapper::entityToDomain),
            teams = entity.teams?.let(matchTeamsMapper::entityToDomain),
            goals = gson.fromJson(entity.goals, Score::class.java),
            score = gson.fromJson(entity.score, MatchScore::class.java)
        )
    }

    override fun dtoToDomain(dto: HeadToHeadDto): HeadToHead {
        return  HeadToHead(
            fixture = dto.fixture?.dtoToDomain(venueMapper),
            league = dto.league?.let(leagueMapper::dtoToDomain),
            teams = dto.teams?.let(matchTeamsMapper::dtoToDomain),
            goals =  dto.goals?.dtoToDomain(),
            score = dto.score?.dtoToDomain()
        )
    }

    override fun domainToEntity(domain: HeadToHead): HeadToHeadEntity {
        return HeadToHeadEntity(
            fixture = gson.toJson(domain.fixture, Fixture::class.java),
            league = domain.league?.let(leagueMapper::domainToEntity),
            teams = domain.teams?.let(matchTeamsMapper::domainToEntity),
            goals = gson.toJson(domain.goals, Score::class.java),
            score = gson.toJson(domain.score, MatchScore::class.java)
        )
    }
}
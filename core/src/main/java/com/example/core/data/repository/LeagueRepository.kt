package com.example.core.data.repository

import com.example.core.data.mapper.LeagueMapper
import com.example.core.data.remote.datasource.LeagueRemoteDataSource
import com.example.core.domain.model.League
import javax.inject.Inject

class LeagueRepository @Inject constructor(
    private val leagueRemoteDataSource: LeagueRemoteDataSource,
    private val leagueMapper: LeagueMapper
) {
    suspend fun getLeague(leagueId: Int): League? {
        val league = leagueRemoteDataSource.fetchLeagues(
            leagueId = leagueId
        )
        return league.response[0].league?.let { leagueMapper.dtoToDomain(it) }
    }

    suspend fun getLeague(teamId: Int, season: Int): League? {
        val league = leagueRemoteDataSource.fetchLeagues(
            teamId = teamId,
            season = 2022
        )
        return league.response[0].league?.let { leagueMapper.dtoToDomain(it) }
    }
}
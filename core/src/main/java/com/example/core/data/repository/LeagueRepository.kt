package com.example.core.data.repository

import com.example.core.data.remote.datasource.LeagueRemoteDataSource
import javax.inject.Inject

class LeagueRepository @Inject constructor(
    private val leagueRemoteDataSource: LeagueRemoteDataSource
) {
    suspend fun getLeague(leagueId: Int) {
        val league = leagueRemoteDataSource.fetchLeagues(
            leagueId = leagueId
        )
    }
    suspend fun getLeague(teamId: Int, season: Int) {
        val league = leagueRemoteDataSource.fetchLeagues(
            teamId = teamId,
            season = season
        )
    }
}
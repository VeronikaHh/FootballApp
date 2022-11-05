package com.example.core.data.repository

import com.example.core.data.local.datasource.TeamLocalDataSource
import com.example.core.data.remote.datasource.LeagueRemoteDataSource
import com.example.core.data.remote.datasource.TeamRemoteDataSource
import javax.inject.Inject

class TeamRepository @Inject constructor(
    private val leagueRemoteDataSource: LeagueRemoteDataSource,
    private val remoteDataSource: TeamRemoteDataSource,
    private val localDataSource: TeamLocalDataSource
){
    suspend fun getTeams() {

    }

    suspend fun getTeam(teamId: Int) {
        val league = leagueRemoteDataSource.fetchLeagues(
            teamId = teamId,
            season = 2022
        )
        val team = remoteDataSource.fetchTeamStatistics(
            season = 2022,
            teamId = teamId,
            leagueId = 1//TODO from league
        )
        // TODO save to db
        // return from db
    }
}
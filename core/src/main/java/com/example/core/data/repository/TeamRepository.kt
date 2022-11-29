package com.example.core.data.repository

import com.example.core.data.mapper.TeamStatisticsMapper
import com.example.core.data.mapper.TeamsMapper
import com.example.core.data.remote.datasource.LeagueRemoteDataSource
import com.example.core.data.remote.datasource.TeamRemoteDataSource
import com.example.core.domain.model.TeamStatistics
import com.example.core.domain.model.Teams
import javax.inject.Inject

class TeamRepository @Inject constructor(
    private val leagueRemoteDataSource: LeagueRemoteDataSource,
    private val remoteDataSource: TeamRemoteDataSource,
    private val teamStatisticsMapper: TeamStatisticsMapper,
    private val teamsMapper: TeamsMapper
){
    suspend fun getTeamStatistics(teamId: Int): TeamStatistics? {
        val league = leagueRemoteDataSource.fetchLeagues(
            teamId = teamId,
            season = 2022
        )
        val team = league.response[0].league?.id?.let {
            remoteDataSource.fetchTeamStatistics(
                teamId = teamId,
                leagueId = it//TODO from league
            )
        }
        return team?.let { teamStatisticsMapper.dtoToDomain(it.response) }
        // TODO save to db
        // return from db
    }

    suspend fun getTeam(teamId: Int): Teams {
        val teams = remoteDataSource.fetchTeams(
            id = teamId
        )
        return teamsMapper.dtoToDomain(teams.response[0])
    }
}
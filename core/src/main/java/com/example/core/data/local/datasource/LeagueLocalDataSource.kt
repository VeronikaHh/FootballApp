package com.example.core.data.local.datasource

import com.example.core.data.local.database.dao.LeagueDao
import com.example.core.data.local.database.dao.LeagueInfoDao
import javax.inject.Inject

class LeagueLocalDataSource @Inject constructor(
    private val leagueDao: LeagueDao,
    private val leagueInfoDao: LeagueInfoDao
){
}
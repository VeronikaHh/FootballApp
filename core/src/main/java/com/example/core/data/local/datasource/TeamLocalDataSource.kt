package com.example.core.data.local.datasource

import com.example.core.data.local.database.dao.TeamDao
import javax.inject.Inject

class TeamLocalDataSource @Inject constructor(
    private val teamDao: TeamDao
) {

}
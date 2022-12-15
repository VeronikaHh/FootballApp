package com.example.core.data.local.datasource

import com.example.core.data.local.database.dao.TransferDao
import com.example.core.data.local.database.dao.TransferTeamDao
import javax.inject.Inject

class TransferLocalDataSource @Inject constructor(
    private val transferDao: TransferDao,
    private val transferTeamDao: TransferTeamDao
){
}
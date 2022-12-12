package com.example.core.data.repository

import com.example.core.data.mapper.HeadToHeadMapper
import com.example.core.data.remote.datasource.HeadToHeadRemoteDataSource
import com.example.core.domain.model.HeadToHead
import javax.inject.Inject

class HeadToHeadRepository @Inject constructor(
    private val headToHeadDataSource: HeadToHeadRemoteDataSource,
    private val mapper: HeadToHeadMapper
) {
    suspend fun getHeadToHead(h2h: String): List<HeadToHead> {
        val headToHead = headToHeadDataSource.fetchHeadToHead(
            h2h = h2h
        )
        return headToHead.response.map(mapper::dtoToDomain)
    }
    suspend fun getHeadToHeadThisSeason(h2h: String): List<HeadToHead> {
        val headToHead = headToHeadDataSource.fetchHeadToHeadThisSeason(
            h2h = h2h
        )
        return headToHead.response.map(mapper::dtoToDomain)
    }
    suspend fun getHeadToHeadLastSeason(h2h: String): List<HeadToHead> {
        val headToHead = headToHeadDataSource.fetchHeadToHeadLastSeason(
            h2h = h2h
        )
        return headToHead.response.map(mapper::dtoToDomain)
    }
}
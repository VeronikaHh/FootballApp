package com.example.core.data.remote.datasource

import com.example.core.data.remote.model.headToHead.HeadToHeadDto
import com.example.core.data.remote.model.response.Response
import com.example.core.di.NetworkModule.provideRetrofit
import com.example.core.di.NetworkModule.providesHeadToHeadService
import javax.inject.Inject

class HeadToHeadRemoteDataSource @Inject constructor(
) {
    suspend fun fetchHeadToHead(h2h: String): Response<List<HeadToHeadDto>> =
        providesHeadToHeadService(provideRetrofit()).fetchHeadToHead(h2h)

    suspend fun fetchHeadToHeadThisSeason(h2h: String): Response<List<HeadToHeadDto>> =
        providesHeadToHeadService(provideRetrofit()).fetchHeadToHeadThisSeason(h2h)

    suspend fun fetchHeadToHeadLastSeason(h2h: String): Response<List<HeadToHeadDto>> =
        providesHeadToHeadService(provideRetrofit()).fetchHeadToHeadLastSeason(h2h)
}
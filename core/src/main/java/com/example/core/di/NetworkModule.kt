package com.example.core.di

import com.example.core.data.service.TeamService
import com.example.core.data.service.PlayerService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private val baseUrl: String = "https://v3.football.api-sports.io/"

    private val okHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(
            Interceptor { chain ->
                val builder = chain.request().newBuilder()
                builder.header("x-rapidapi-host", "v3.football.api-sports.io")
                builder.header("x-rapidapi-key", "dd0226de9135c65688994e14cb09d2d5")
                return@Interceptor chain.proceed(builder.build())
            }
        )
    }.build()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .baseUrl(baseUrl)
        .build()

    @Provides
    fun providesTeamService(retrofit: Retrofit): TeamService {
        return retrofit.create(TeamService::class.java)
    }

    @Provides
    fun providesPlayerService(retrofit: Retrofit): PlayerService {
        return retrofit.create(PlayerService::class.java)
    }
}
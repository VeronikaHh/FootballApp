package com.example.core.di

import android.content.Context
import androidx.room.Room
import com.example.core.data.database.FootballDatabase
import com.example.core.data.mapper.PlayerMapper
import com.example.core.domain.mapper.Mapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MapperModule {
    //TODO: functions that provide mappers
}
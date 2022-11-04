package com.example.core.di

import android.content.Context
import androidx.room.Room
import com.example.core.data.local.database.FootballDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): FootballDatabase =
        Room.databaseBuilder(context, FootballDatabase::class.java, "footballDatabase")
            .build()
}
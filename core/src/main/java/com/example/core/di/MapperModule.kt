package com.example.core.di


import com.example.core.data.mapper.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class MapperModule {
    @Provides
    fun provideBiggestMapper(): BiggestMapper {
        return BiggestMapper()
    }

    @Provides
    fun provideTotalAverageMapper(): TotalAverageMapper {
        return TotalAverageMapper()
    }

    @Provides
    fun provideTotalMapper(): TotalMapper {
        return TotalMapper()
    }

    @Provides
    fun provideVenueMapper(): VenueMapper {
        return VenueMapper()
    }

    @Provides
    fun provideTeamMapper(): TeamMapper {
        return TeamMapper()
    }

    @Provides
    fun provideTeamsMapper(): TeamsMapper {
        return TeamsMapper()
    }

    @Provides
    fun provideGoalsMapper(): GoalsMapper {
        return GoalsMapper()
    }

    @Provides
    fun provideFixturesMapper(): FixturesMapper {
        return FixturesMapper()
    }

    @Provides
    fun provideLeagueMapper(): LeagueMapper {
        return LeagueMapper()
    }

    @Provides
    fun provideScoreMapper(): ScoreMapper {
        return ScoreMapper()
    }

    @Provides
    fun provideStreakMapper(): StreakMapper {
        return StreakMapper()
    }

    @Provides
    fun providePlayerMapper(): PlayerMapper {
        return PlayerMapper()
    }

    @Provides
    fun provideTeamStatistics(): TeamStatisticsMapper {
        return TeamStatisticsMapper()
    }

    @Provides
    fun providePlayerSquadMapper(): PlayerSquadMapper {
        return PlayerSquadMapper()
    }
}
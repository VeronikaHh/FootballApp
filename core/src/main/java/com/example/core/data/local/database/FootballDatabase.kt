package com.example.core.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.data.local.model.*

@Database(
    entities = [
        PlayerEntity::class,
        LeagueEntity::class,
        TeamEntity::class,
        VenueEntity::class,
        TeamsEntity::class,
        PlayerSquadEntity::class,
        LeagueInfoEntity::class,
        CountryEntity::class,
        SeasonEntity::class
    ], version = 1
)
abstract class FootballDatabase : RoomDatabase() {
}
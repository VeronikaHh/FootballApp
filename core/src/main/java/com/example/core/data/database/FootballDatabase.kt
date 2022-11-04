package com.example.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.data.database.entity.*

@Database(
    entities = [
        PlayerEntity::class,
        PlayerSquadEntity::class,
        GoalsEntity::class,
        TeamEntity::class,
        TeamStatisticsEntity::class,
        LeagueEntity::class,
        GoalsEntity::class,
        StreakEntity::class,
        TotalEntity::class,
        VenueEntity::class,
        FixturesEntity::class,
        BiggestEntity::class,
        ScoreEntity::class
    ], version = 1
)
abstract class FootballDatabase : RoomDatabase() {
//    abstract val teamDao: TeamDao
//    abstract val teamStatisticsDao: TeamStatisticsDao
//    abstract val venueDao: VenueDao
//    abstract val playerDao: PlayerDao
//    abstract val playerSquadDao: PlayerSquadDao
//    abstract val leagueDao: LeagueDao
//    abstract val biggestDao: BiggestDao
//    abstract val goalsDao: GoalsDao
//    abstract val totalDao: TotalDao
//    abstract val totalAverageDao: TotalAverageDao
//    abstract val streakDao: StreakDao
//    abstract val fixturesDao: FixturesDao
//    abstract val scoreDao: ScoreDao
}
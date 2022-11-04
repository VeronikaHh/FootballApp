package com.example.core.data.local.model

import androidx.room.Entity

@Entity//(tableName = "player_squad_table")
data class PlayerSquadEntity(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int,
    val team: TeamEntity? = null,
    val players: List<PlayerEntity>? = null
)
package com.example.core.data.local.model

import androidx.room.Entity

@Entity//(tableName = "player_squad_table")
data class PlayerSquadEntity(
    val team: TeamEntity? = null,
    val players: List<PlayerEntity>? = null
//    @ForeignKey(
//        entity = PlayerEntity::class,
//        parentColumns = ["players"],
//        childColumns = ["id"],
//        onDelete = ForeignKey.CASCADE)
//    var players: Long? = null,
)
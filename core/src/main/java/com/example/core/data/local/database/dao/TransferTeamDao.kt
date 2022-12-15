package com.example.core.data.local.database.dao

import androidx.room.*
import com.example.core.data.local.model.TransferTeamEntity

interface TransferTeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(transferTeamEntity: TransferTeamEntity)

    @Update
    fun update(transferTeamEntity: TransferTeamEntity)

    @Delete
    fun delete(transferTeamEntity: TransferTeamEntity)

    @Query("SELECT * FROM TransferTeamEntity")
    fun getAll(): List<TransferTeamEntity>

    @Query("SELECT * FROM TransferTeamEntity")
    fun getTransfer(): TransferTeamEntity
}
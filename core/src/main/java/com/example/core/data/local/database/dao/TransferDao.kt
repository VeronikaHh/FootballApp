package com.example.core.data.local.database.dao

import androidx.room.*
import com.example.core.data.local.model.TransferEntity
import com.example.core.data.local.model.TransferTeamEntity

interface TransferDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(transferEntity: TransferEntity)

    @Update
    fun update(transferEntity: TransferEntity)

    @Delete
    fun delete(transferEntity: TransferEntity)

    @Query("SELECT * FROM TransferEntity")
    fun getAll(): List<TransferEntity>

    @Query("SELECT * FROM TransferEntity WHERE teams Like teams")
    fun getTransfer(teams: TransferTeamEntity): TransferEntity
}
package com.example.core.data.remote.model.transfer

import com.example.core.data.remote.model.players.PlayerDto

data class PlayerTransfersDto(
    val player: PlayerDto ?= null,
    val transfers: List<TransferDto> ?=null
)
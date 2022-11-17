package com.example.holovanova_football.viewmodel

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.repository.PlayerRepository
import com.example.core.data.repository.TransferRepository
import com.example.core.domain.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import java.util.ListResourceBundle
import javax.inject.Inject


@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val transferRepository: TransferRepository,
    private val playerRepository: PlayerRepository
) : ViewModel() {

    var isDataFetched = false
    private val _transfer = MutableStateFlow<PlayerTransfers>(PlayerTransfers())
    private val _playerStatistics = MutableStateFlow<PlayerStatistics>(PlayerStatistics())

    private val _data = MutableStateFlow<PlayerFragmentData>(PlayerFragmentData())
    val data: StateFlow<PlayerFragmentData>
        get() = _data


    fun collectFlow(player: Int, team: Int) {
        viewModelScope.launch {
            _transfer.value = transferRepository.getTransfers(player)
            _playerStatistics.value = playerRepository.getPlayerStatistics(player, team)
            combine(_playerStatistics, _transfer) { playerStatistics, transfer ->
                _data.value = data.value.copy(
                    transfer = transfer,
                    player = playerStatistics.player,
                    statistics = playerStatistics.statistics
                )
            }.collect()
        }
        isDataFetched = true
    }
}
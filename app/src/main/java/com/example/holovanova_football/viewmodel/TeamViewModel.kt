package com.example.holovanova_football.viewmodel

import androidx.lifecycle.*
import com.example.core.data.repository.PlayerRepository
import com.example.core.data.repository.TeamRepository
import com.example.core.domain.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.combine as combine

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val teamRepository: TeamRepository,
    private val playerRepository: PlayerRepository
) : ViewModel() {

    var isDataFetched = false
    private val _playerSquad = MutableStateFlow<PlayerSquad>(PlayerSquad())
    private val _team = MutableStateFlow<Teams>(Teams())
    private val _teamStatistics = MutableStateFlow<TeamStatistics?>(TeamStatistics())

    private val _data = MutableStateFlow<TeamFragmentData>(TeamFragmentData())
    val data: StateFlow<TeamFragmentData>
        get() = _data

    init {
        collectFlow(33)
    }

    fun collectFlow(team: Int) {
        viewModelScope.launch {
            _playerSquad.value = playerRepository.getPlayerSquad(team)
            _team.value = teamRepository.getTeam(team)
            _teamStatistics.value = teamRepository.getTeamStatistics(team)
            combine(_team, _teamStatistics, _playerSquad) { team, teamStatistics, playerSquad ->
                _data.value = data.value.copy(
                    team = team,
                    teamStatistics = teamStatistics,
                    playerSquad = playerSquad
                )
            }.collect()
        }
        isDataFetched = true
    }
}
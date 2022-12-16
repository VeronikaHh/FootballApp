package com.example.holovanova_football.viewmodel

import androidx.lifecycle.*
import com.example.core.data.repository.PlayerRepository
import com.example.core.data.repository.TeamRepository
import com.example.core.domain.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.combine as combine

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val teamRepository: TeamRepository,
    private val playerRepository: PlayerRepository
) : ViewModel() {

    private val _playerSquad = MutableStateFlow(PlayerSquad())
    private val _team = MutableStateFlow(Teams())
    private val _teamStatistics = MutableStateFlow<TeamStatistics?>(TeamStatistics())

    var isDataFetched = false
    private val _data = MutableStateFlow(TeamFragmentData())

    val data: StateFlow<TeamFragmentData>
        get() = _data

    fun collectFlow(team: Int) {
        viewModelScope.launch(Dispatchers.Default) {
            _playerSquad.value = playerRepository.getPlayerSquad(team)
            _team.value = teamRepository.getTeam(team)
            _teamStatistics.value = teamRepository.getTeamStatistics(team)
            isDataFetched = true
            combine(_team, _teamStatistics, _playerSquad) { team, teamStatistics, playerSquad ->
                _data.value = data.value.copy(
                    team = team,
                    teamStatistics = teamStatistics,
                    playerSquad = playerSquad
                )
            }.collect()
        }
    }
}
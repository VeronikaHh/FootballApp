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

//    private val _team = MutableStateFlow<TeamState>(TeamState.Empty)
//    private val _teamStatistics = MutableStateFlow<TeamStatisticsState>(TeamStatisticsState.Empty)
//    private val _playerSquad = MutableStateFlow<PlayerSquadState>(PlayerSquadState.Empty)
//
//    private val _data = combine(
//        _playerSquad,
//        _team,
//        _teamStatistics
//    ) { playerSquad, team, teamStatistics ->
//        playerSquad is PlayerSquadState.Selected
//                && team is TeamState.Selected
//                && teamStatistics is TeamStatisticsState.Selected
//    }.stateIn(viewModelScope, SharingStarted.Eagerly, false)

//    val playerSquad: StateFlow<PlayerSquadState>
//        get() = _playerSquad
//
//    val team: StateFlow<TeamState>
//        get() = _team
//
//    val teamStatistics: StateFlow<TeamStatisticsState>
//        get() = _teamStatistics
//
//    val data: StateFlow<Boolean>
//        get() = _data
//
//
//    fun collectFlow(teamId: Int){
//        fetchTeam(teamId)
//        fetchTeamStatistics(teamId)
//        fetchPlayerSquad(teamId)
//    }
//
//    private fun fetchTeam(teamId: Int) = viewModelScope.launch(Dispatchers.Default) {
//        _team.emit(TeamState.Loading)
//        val teams = teamRepository.getTeam(teamId)
//        _team.emit(TeamState.Selected(teams))
//    }
//
//    private fun fetchTeamStatistics(teamId: Int) = viewModelScope.launch(Dispatchers.Default) {
//        _teamStatistics.emit(TeamStatisticsState.Loading)
//        val teamStatistics = teamRepository.getTeamStatistics(teamId)
//        teamStatistics?.let { TeamStatisticsState.Selected(it) }?.let { _teamStatistics.emit(it) }
//    }
//
//    private fun fetchPlayerSquad(teamId: Int) = viewModelScope.launch(Dispatchers.Default) {
//        _playerSquad.emit(PlayerSquadState.Loading)
//        val playerSquad = playerRepository.getPlayerSquad(teamId)
//        _playerSquad.emit(PlayerSquadState.Selected(playerSquad))
//    }

    private val _playerSquad = MutableStateFlow(PlayerSquad())
    private val _team = MutableStateFlow(Teams())
    private val _teamStatistics = MutableStateFlow<TeamStatistics?>(TeamStatistics())

    private val _data = MutableStateFlow(TeamFragmentData())

    val data: StateFlow<TeamFragmentData>
        get() = _data

    fun collectFlow(team: Int) {
        viewModelScope.launch(Dispatchers.Default) {
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
    }
}

//sealed interface TeamState {
//    object Empty : TeamState
//    object Loading : TeamState
//    data class Selected(
//        val team: Teams
//    ) : TeamState
//}
//
//sealed interface TeamStatisticsState {
//    object Empty : TeamStatisticsState
//    object Loading : TeamStatisticsState
//    data class Selected(
//        val teamStatistics: TeamStatistics
//    ) : TeamStatisticsState
//}
//
//sealed interface PlayerSquadState {
//    object Empty : PlayerSquadState
//    object Loading : PlayerSquadState
//    data class Selected(
//        val playerSquad: PlayerSquad,
//    ) : PlayerSquadState
//}
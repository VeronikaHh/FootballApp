package com.example.holovanova_football.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.repository.TeamRepository
import com.example.core.domain.model.Teams
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CompareViewModel @Inject constructor(
    private val teamRepository: TeamRepository
) : ViewModel() {

    private val _firstTeamState = MutableStateFlow<SelectedTeamState>(SelectedTeamState.Empty)
    private val _secondTeamState = MutableStateFlow<SelectedTeamState>(SelectedTeamState.Empty)
    private val _buttonEnabled = combine(
        _firstTeamState,
        _secondTeamState
    ) { firstTeamState, secondTeamState ->
        firstTeamState is SelectedTeamState.Selected
                && secondTeamState is SelectedTeamState.Selected
    }.stateIn(viewModelScope, SharingStarted.Eagerly, false)

    val firstTeamState: StateFlow<SelectedTeamState>
        get() = _firstTeamState

    val secondTeamState: StateFlow<SelectedTeamState>
        get() = _secondTeamState

    val buttonEnabled: StateFlow<Boolean>
        get() = _buttonEnabled

    fun fetchFirstTeam(teamId: Int) = viewModelScope.launch(Dispatchers.Default) {
        _firstTeamState.emit(SelectedTeamState.Loading)
        val teams = fetchTeam(teamId)
        _firstTeamState.emit(SelectedTeamState.Selected(team = teams))
    }

    fun fetchSecondTeam(teamId: Int) = viewModelScope.launch(Dispatchers.Default) {
        _secondTeamState.emit(SelectedTeamState.Loading)
        val teams = fetchTeam(teamId)
        _secondTeamState.emit(SelectedTeamState.Selected(team = teams))
    }

    private suspend fun fetchTeam(teamId: Int): Teams {
        return teamRepository.getTeam(teamId)
    }
}

sealed interface SelectedTeamState {
    object Empty : SelectedTeamState
    object Loading : SelectedTeamState
    data class Selected(val team: Teams) : SelectedTeamState
}
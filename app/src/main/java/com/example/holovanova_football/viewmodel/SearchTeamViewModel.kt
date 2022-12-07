package com.example.holovanova_football.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.repository.TeamRepository
import com.example.core.domain.model.Teams
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchTeamViewModel @Inject constructor(
    private val teamRepository: TeamRepository
) : ViewModel() {

    private val _teamsState = MutableStateFlow<SearchState>(SearchState.Empty)
    val teamsState: StateFlow<SearchState>
        get() = _teamsState

    init {
        collectFlow("england")
    }

    fun collectFlow(search: String) {
        viewModelScope.launch(Dispatchers.Default) {
            _teamsState.emit(SearchState.Loading)
            val teams = teamRepository.searchTeam(search)
            _teamsState.emit(SearchState.Selected(teams = teams))
        }
    }
}

sealed interface SearchState {
    object Empty: SearchState
    object Loading : SearchState
    data class Selected(val teams: List<Teams>) : SearchState
}
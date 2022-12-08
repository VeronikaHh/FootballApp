package com.example.holovanova_football.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.repository.TeamRepository
import com.example.core.domain.model.Teams
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchTeamViewModel @Inject constructor(
    private val teamRepository: TeamRepository
) : ViewModel() {

    private val _teams = MutableStateFlow<List<Teams>>(emptyList())
    val teams: StateFlow<List<Teams>>
        get() = _teams

    init {
        collectFlow("england")
    }

    fun collectFlow(search: String) {
        viewModelScope.launch {
            _teams.value = teamRepository.searchTeam(search)
        }
    }
}
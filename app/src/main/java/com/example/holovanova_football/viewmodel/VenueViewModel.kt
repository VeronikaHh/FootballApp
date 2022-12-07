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
class VenueViewModel @Inject constructor(
    private val teamRepository: TeamRepository
) : ViewModel() {

    private val _team = MutableStateFlow(Teams())

    val team: StateFlow<Teams>
        get() = _team

    fun collectFlow(team: Int) {
        viewModelScope.launch(Dispatchers.Default) {
            _team.value = teamRepository.getTeam(team)
        }
    }
}
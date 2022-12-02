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
class CompareViewModel @Inject constructor(
    private val teamRepository: TeamRepository
) : ViewModel() {

    var isDataFetched = false

    private val _team = MutableStateFlow<Teams>(Teams())
    val data: StateFlow<Teams>
        get() = _team

    fun collectFlow(team: Int) {
        viewModelScope.launch {
            _team.value = teamRepository.getTeam(team)
        }
        isDataFetched = true
    }
}
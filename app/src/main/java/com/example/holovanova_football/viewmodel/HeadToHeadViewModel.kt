package com.example.holovanova_football.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.repository.HeadToHeadRepository
import com.example.core.domain.model.HeadToHead
import com.example.core.domain.model.HeadToHeadFragmentData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HeadToHeadViewModel @Inject constructor(
    private val headToHeadRepository: HeadToHeadRepository
) : ViewModel() {

    private val _lastTen = MutableStateFlow<List<HeadToHead>>(emptyList())
    private val _thisSeason = MutableStateFlow<List<HeadToHead>>(emptyList())
    private val _lastSeason = MutableStateFlow<List<HeadToHead>>(emptyList())
    private val _data = MutableStateFlow(HeadToHeadFragmentData())

    var isDataFetched = false
    val data: StateFlow<HeadToHeadFragmentData>
        get() = _data

    fun collectFlow(firstTeamId: Int, secondTeamId: Int) {
        val h2h = "$firstTeamId-$secondTeamId"
        viewModelScope.launch(Dispatchers.Default) {
            _lastTen.emit(headToHeadRepository.getHeadToHead(h2h))
            _thisSeason.emit(headToHeadRepository.getHeadToHeadThisSeason(h2h))
            _lastSeason.emit(headToHeadRepository.getHeadToHeadLastSeason(h2h))
            isDataFetched = true
            combine(
                _lastSeason,
                _thisSeason,
                _lastTen
            ) { lastSeason, thisSeason, lastTen ->
                _data.value = data.value.copy(
                    thisSeason = thisSeason,
                    lastTen = lastTen,
                    lastSeason = lastSeason,
                    teams = lastTen[0].teams
                )
            }.collect()
        }
    }
}
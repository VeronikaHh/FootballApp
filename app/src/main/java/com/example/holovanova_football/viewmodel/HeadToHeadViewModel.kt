package com.example.holovanova_football.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.repository.HeadToHeadRepository
import com.example.core.data.repository.TeamRepository
import com.example.core.domain.model.HeadToHead
import com.example.core.domain.model.HeadToHeadFragmentData
import com.example.core.domain.model.Teams
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HeadToHeadViewModel @Inject constructor(
    private val headToHeadRepository: HeadToHeadRepository,
    private val teamRepository: TeamRepository
) : ViewModel() {

    private val _lastTen = MutableStateFlow<List<HeadToHead>>(emptyList())
    private val _thisSeason = MutableStateFlow<List<HeadToHead>>(emptyList())
    private val _lastSeason = MutableStateFlow<List<HeadToHead>>(emptyList())
    private val _homeTeam = MutableStateFlow(Teams())
    private val _awayTeam = MutableStateFlow(Teams())
    private val _data = MutableStateFlow(HeadToHeadFragmentData())

    val data: StateFlow<HeadToHeadFragmentData>
        get() = _data


    fun collectFlow(firstTeamId: Int, secondTeamId: Int) {
        val h2h = "$firstTeamId-$secondTeamId"
        viewModelScope.launch(Dispatchers.Default) {
            _lastTen.emit(headToHeadRepository.getHeadToHead(h2h))
            _thisSeason.emit(headToHeadRepository.getHeadToHeadThisSeason(h2h))
            _lastSeason.emit(headToHeadRepository.getHeadToHeadLastSeason(h2h))
            _homeTeam.emit(teamRepository.getTeam(firstTeamId))
            _awayTeam.emit(teamRepository.getTeam(secondTeamId))
            combine(
                _lastSeason,
                _thisSeason,
                _lastTen,
                _homeTeam,
                _awayTeam
            ) { lastSeason, thisSeason, lastTen, homeTeam, awayTeam ->
                _data.value = data.value.copy(
                    thisSeason = thisSeason,
                    lastTen = lastTen,
                    lastSeason = lastSeason,
                    teams = lastTen[0].teams,
                    homeVenue = homeTeam.venue,
                    awayVenue = awayTeam.venue
                )
            }.collect()
        }
    }
//    fun collectLastTen(h2h: String) {
//        viewModelScope.launch(Dispatchers.Default) {
//            _lastTen.emit(headToHeadRepository.getHeadToHead(h2h))
//        }
//    }
//    fun collectThisSeason(h2h: String) {
//        viewModelScope.launch(Dispatchers.Default) {
//            _thisSeason.emit(headToHeadRepository.getHeadToHeadThisSeason(h2h))
//        }
//    }
//    fun collectLastSeason(h2h: String) {
//        viewModelScope.launch(Dispatchers.Default) {
//            _lastSeason.emit(headToHeadRepository.getHeadToHeadLastSeason(h2h))
//        }
//    }
}
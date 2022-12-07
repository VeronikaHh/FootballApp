package com.example.holovanova_football.holder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.core.domain.model.HeadToHead
import com.example.holovanova_football.databinding.MatchRvItemBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MatchHolder(
    val binding: MatchRvItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(h2h: HeadToHead) {
        binding.leagueName.text = h2h.league?.name

        h2h.teams?.home?.let {
            binding.firstTeamName.text = it.name
            binding.firstTeamLogo.load(it.logo)
        }
        h2h.teams?.away?.let {
            binding.secondTeamName.text = it.name
            binding.secondTeamLogo.load(it.logo)
        }
        h2h.fixture?.status?.let {
            binding.matchStatus.text = it.long
            binding.matchTime.text = "${it.elapsed?: 0}`"
        }

        h2h.score?.fulltime?.let {
            binding.firstTeamScore.text = it.home
            binding.secondTeamScore.text = it.away
        }

        binding.date.text = h2h.fixture?.date?.let { parseDate(it) }

        h2h.fixture?.venue?.let {
            binding.venueAddress.text = it.city?:""
        }
        binding.referee.text = h2h.fixture?.referee?:""
    }

    private fun parseDate(date: String): String {
        val reformattedDate = date.slice(0..9)
        val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val result = LocalDate.parse(reformattedDate, firstApiFormat)
        return "${result.dayOfMonth} ${result.month} ${result.year}"
    }
}
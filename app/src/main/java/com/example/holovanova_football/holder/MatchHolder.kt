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

        binding.firstTeamName.text = h2h.teams?.home?.name
        binding.firstTeamLogo.load(h2h.teams?.home?.logo)

        binding.secondTeamName.text = h2h.teams?.away?.name
        binding.secondTeamLogo.load(h2h.teams?.away?.logo)

        binding.matchStatus.text = h2h.fixture?.status?.long
        binding.matchTime.text = "${h2h.fixture?.status?.elapsed}`"

        binding.firstTeamScore.text = h2h.score?.fulltime?.home
        binding.secondTeamScore.text = h2h.score?.fulltime?.away
        
        binding.date.text = h2h.fixture?.date?.let { parseDate(it) }
    }

    private fun parseDate(date: String): String {
        val reformattedDate = date.slice(0..9)
        val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val result = LocalDate.parse(reformattedDate, firstApiFormat)
        return "${result.dayOfMonth} ${result.month} ${result.year}"
    }
}
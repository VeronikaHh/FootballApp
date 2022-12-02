package com.example.holovanova_football.holder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.core.domain.model.Team
import com.example.holovanova_football.databinding.TeamRvItemBinding

class TeamHolder(
    val binding: TeamRvItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(team: Team){
        binding.teamLogo.load(team.logo)
        binding.teamName.text = team.name
        binding.countryName.text = team.country
        binding.teamCode.text = team.code
    }
}
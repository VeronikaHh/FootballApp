package com.example.holovanova_football.holder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.core.domain.model.Transfer
import com.example.holovanova_football.databinding.CareerRvItemBinding

class CareerHolder(
    val binding: CareerRvItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(transfer: Transfer) {
        binding.date.text = transfer.date
        binding.type.text = transfer.type
        binding.inTeam.load(transfer.teams?.inTeam?.logo)
        binding.outTeam.load(transfer.teams?.outTeam?.logo)
    }
}
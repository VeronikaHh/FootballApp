package com.example.holovanova_football.holder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.core.domain.model.Player
import com.example.holovanova_football.databinding.PlayerRvItemBinding

class PlayerHolder(
    val binding: PlayerRvItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(player: Player) {
        binding.playerName.text = player.name
        binding.playerNumber.text = player.number?.toString() ?: "NA"
        binding.playerPosition.text = player.position
        binding.playerPhoto.load(player.photo)
    }
}

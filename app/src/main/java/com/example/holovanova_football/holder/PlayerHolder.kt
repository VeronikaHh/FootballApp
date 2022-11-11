package com.example.holovanova_football.holder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.domain.model.Player
import com.example.holovanova_football.databinding.PlayerRvItemBinding

class PlayerHolder(
    val binding: PlayerRvItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(player: Player){
        binding.playerName.text = player.name
        binding.playerNumber.text = player.number.toString()
        binding.playerPosition.text = player.position
        Glide.with(binding.playerPhoto.context)
            .load(player.photo)
            .into(binding.playerPhoto)
    }
}

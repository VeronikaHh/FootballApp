package com.example.holovanova_football.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.domain.model.Player
import com.example.holovanova_football.databinding.PlayerRvItemBinding
import com.example.holovanova_football.holder.PlayerHolder

class PlayerAdapter : RecyclerView.Adapter<PlayerHolder>() {

    private val players = mutableListOf<Player>()

    fun setData(playerList: List<Player>) {
        //TODO add diffUtils
        players.clear()
        players.addAll(playerList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerHolder {
        val binding =
            PlayerRvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return PlayerHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerHolder, position: Int) {
        holder.bind(players[position])
    }

    override fun getItemCount() = players.count()
}
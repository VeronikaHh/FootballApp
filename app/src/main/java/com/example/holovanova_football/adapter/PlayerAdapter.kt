package com.example.holovanova_football.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.core.domain.model.Player
import com.example.holovanova_football.databinding.PlayerRvItemBinding
import com.example.holovanova_football.holder.PlayerHolder
import com.example.holovanova_football.util.PlayerDiffUtil

class PlayerAdapter(
    private val onClickListener: (playerId: Int) -> Unit
) : RecyclerView.Adapter<PlayerHolder>() {

    private var players = mutableListOf<Player>()

    fun setData(newPlayerList: List<Player>) {
        val diffUtil = PlayerDiffUtil(players, newPlayerList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        players = newPlayerList.toMutableList()
        diffResults.dispatchUpdatesTo(this)
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
        holder.itemView.setOnClickListener {
            val playerId = players[position].id ?: return@setOnClickListener
            onClickListener(playerId)
        }
        holder.bind(players[position])
    }

    override fun getItemCount() = players.count()
}
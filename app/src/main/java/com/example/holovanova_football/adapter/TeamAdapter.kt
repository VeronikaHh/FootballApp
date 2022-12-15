package com.example.holovanova_football.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.core.domain.model.Team
import com.example.holovanova_football.databinding.TeamRvItemBinding
import com.example.holovanova_football.holder.TeamHolder
import com.example.holovanova_football.util.TeamDiffUtil

class TeamAdapter(
    private val onClickListener: (teamId: Int) -> Unit
) : RecyclerView.Adapter<TeamHolder>() {

    private var teams = mutableListOf<Team>()

    fun setData(newTeamList: List<Team>) {
        val diffUtil = TeamDiffUtil(teams, newTeamList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        teams = newTeamList.toMutableList()
        diffResults.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
        val binding =
            TeamRvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return TeamHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val teamId = teams[position].id ?: return@setOnClickListener
            onClickListener(teamId)
        }
        holder.bind(teams[position])
    }

    override fun getItemCount() = teams.count()
}
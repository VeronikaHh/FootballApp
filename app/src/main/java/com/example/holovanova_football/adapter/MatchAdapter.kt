package com.example.holovanova_football.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.core.domain.model.HeadToHead
import com.example.holovanova_football.databinding.MatchRvItemBinding
import com.example.holovanova_football.holder.MatchHolder
import com.example.holovanova_football.util.MatchDiffUtil

class MatchAdapter : RecyclerView.Adapter<MatchHolder>() {

    private var matchList = mutableListOf<HeadToHead>()

    fun setData(newList: List<HeadToHead>){
        val diffUtil = MatchDiffUtil(matchList, newList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        matchList = newList.toMutableList()
        diffResults.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchHolder {
        val binding =
            MatchRvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return MatchHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchHolder, position: Int) {
        holder.bind(matchList[position])
    }

    override fun getItemCount(): Int = matchList.count()
}
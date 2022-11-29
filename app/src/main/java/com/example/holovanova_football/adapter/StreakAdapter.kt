package com.example.holovanova_football.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.holovanova_football.databinding.StreakItemBinding
import com.example.holovanova_football.holder.StreakHolder
import com.example.holovanova_football.util.PlayerDiffUtil
import com.example.holovanova_football.util.StreakDiffUtil

class StreakAdapter : RecyclerView.Adapter<StreakHolder>() {

    private var streak = mutableListOf<String>()

    fun setData(form: String) {
        var newStreak: List<String> = emptyList()
        for (element in form) {
            newStreak = newStreak + element.toString()
        }

        val diffUtil = StreakDiffUtil(streak, newStreak)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        streak = newStreak.toMutableList()
        diffResults.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StreakHolder {
        val binding = StreakItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return StreakHolder(binding)
    }

    override fun onBindViewHolder(holder: StreakHolder, position: Int) {
        holder.bind(streak[position])
    }

    override fun getItemCount(): Int = streak.count()
}
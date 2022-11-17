package com.example.holovanova_football.holder

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.holovanova_football.R
import com.example.holovanova_football.databinding.StreakItemBinding

class StreakHolder(val binding: StreakItemBinding):
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: String){
        binding.streakValue.text = data
        val color = when(data) {
            "W" -> ContextCompat.getColor(binding.root.context,R.color.streak_green)
            "L" -> ContextCompat.getColor(binding.root.context,R.color.streak_red)
            else -> ContextCompat.getColor(binding.root.context,R.color.streak_yellow)
        }
        binding.streakContainer.setCardBackgroundColor(color)
    }
}
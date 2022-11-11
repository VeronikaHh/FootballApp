package com.example.holovanova_football.holder

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.example.holovanova_football.databinding.StreakItemBinding

class StreakHolder(val binding: StreakItemBinding):
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: String){
        binding.streakValue.text = data
        when(data) {
            "W" -> binding.streakContainer.setCardBackgroundColor(Color.parseColor("#01B53E"))
            "L" -> binding.streakContainer.setCardBackgroundColor(Color.parseColor("#CF0000"))
            "D" -> binding.streakContainer.setCardBackgroundColor(Color.parseColor("#F2BD00"))
        }
    }
}
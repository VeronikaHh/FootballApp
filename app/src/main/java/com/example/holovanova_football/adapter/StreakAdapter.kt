package com.example.holovanova_football.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.holovanova_football.databinding.StreakItemBinding
import com.example.holovanova_football.holder.StreakHolder

class StreakAdapter : RecyclerView.Adapter<StreakHolder>() {

    private val streak = mutableListOf<String>()

    fun setData(form: String) {
        //TODO add diffUtils
        streak.clear()
        for (i in 0 until form.length) {
            streak += form[i].toString()
        }
        notifyDataSetChanged()
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
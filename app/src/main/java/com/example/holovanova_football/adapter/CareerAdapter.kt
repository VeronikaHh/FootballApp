package com.example.holovanova_football.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.core.domain.model.Transfer
import com.example.holovanova_football.databinding.CareerRvItemBinding
import com.example.holovanova_football.holder.CareerHolder
import com.example.holovanova_football.util.CareerDiffUtil

class CareerAdapter : RecyclerView.Adapter<CareerHolder>() {

    private var transfers = mutableListOf<Transfer>()

    fun setData(newList: List<Transfer>) {
        val diffUtil = CareerDiffUtil(transfers, newList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        transfers = newList.toMutableList()
        diffResults.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CareerHolder {
        val binding =
            CareerRvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return CareerHolder(binding)
    }

    override fun onBindViewHolder(holder: CareerHolder, position: Int) {
        holder.bind(transfers[position])
    }

    override fun getItemCount(): Int = transfers.count()
}
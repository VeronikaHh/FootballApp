package com.example.holovanova_football.util

import androidx.recyclerview.widget.DiffUtil
import com.example.core.domain.model.Player

class PlayerDiffUtil(
    private val oldList: List<Player>,
    private val newList: List<Player>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.count()

    override fun getNewListSize(): Int = newList.count()

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}
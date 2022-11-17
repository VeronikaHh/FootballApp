package com.example.holovanova_football.util

import androidx.recyclerview.widget.DiffUtil
import com.example.core.domain.model.Player

class PlayerDiffUtil(
    private val oldList: List<Player>,
    private val newList: List<Player>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.count()

    override fun getNewListSize(): Int = newList.count()

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].id != newList[newItemPosition].id -> false
            oldList[oldItemPosition].age != newList[newItemPosition].age -> false
            oldList[oldItemPosition].name != newList[newItemPosition].name -> false
            oldList[oldItemPosition].number != newList[newItemPosition].number -> false
            oldList[oldItemPosition].position != newList[newItemPosition].position -> false
            oldList[oldItemPosition].photo != newList[newItemPosition].photo -> false
            else -> true
        }
    }
}
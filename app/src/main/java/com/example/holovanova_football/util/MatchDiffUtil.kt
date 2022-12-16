package com.example.holovanova_football.util

import androidx.recyclerview.widget.DiffUtil
import com.example.core.domain.model.HeadToHead

class MatchDiffUtil(
    private val oldList: List<HeadToHead>,
    private val newList: List<HeadToHead>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.count()

    override fun getNewListSize(): Int = newList.count()

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].fixture?.id == newList[newItemPosition].fixture?.id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}
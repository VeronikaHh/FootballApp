package com.example.holovanova_football.util

import androidx.recyclerview.widget.DiffUtil
import com.example.core.domain.model.Team

class TeamDiffUtil(
    private val oldList: List<Team>,
    private val newList: List<Team>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.count()

    override fun getNewListSize(): Int = newList.count()

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}
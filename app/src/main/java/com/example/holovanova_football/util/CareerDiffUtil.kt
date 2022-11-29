package com.example.holovanova_football.util

import androidx.recyclerview.widget.DiffUtil
import com.example.core.domain.model.Transfer

class CareerDiffUtil(
    private val oldList: List<Transfer>,
    private val newList: List<Transfer>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.count()

    override fun getNewListSize(): Int = newList.count()

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}
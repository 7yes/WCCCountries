package com.example.countries.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.countries.domain.model.CountryItem

class CountryDiffUtil(
    private val oldList: List<CountryItem>,
    private val newList: List<CountryItem>
):DiffUtil.Callback(){
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList[oldItemPosition].code == newList[newItemPosition].code ) &&
        return (oldList[oldItemPosition].region == newList[newItemPosition].region )
    }

}
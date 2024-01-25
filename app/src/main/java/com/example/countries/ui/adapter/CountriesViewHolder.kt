package com.example.countries.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.databinding.ItemSmallBinding
import com.example.countries.domain.model.CountryItem

class CountriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSmallBinding.bind(view)
    fun bind(item: CountryItem) {
        binding.tvNameRegionCode.text = "${item.name}, ${item.region} ${item.code}"
        binding.tvCapital.text = item.capital
    }
}
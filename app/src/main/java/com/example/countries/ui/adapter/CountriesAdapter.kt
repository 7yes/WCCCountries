package com.example.countries.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.R
import com.example.countries.domain.model.CountryItem

class CountriesAdapter(private var countryList: List<CountryItem>, private val onCLickLis:(CountryItem)->Unit) :
    RecyclerView.Adapter<CountriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CountriesViewHolder(layoutInflater.inflate(R.layout.item_small, parent, false))
    }

    override fun getItemCount(): Int = countryList.size

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val item = countryList[position]
        holder.bind(item, onCLickLis)
    }
}
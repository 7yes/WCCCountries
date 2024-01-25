package com.example.countries.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countries.databinding.ActivityMainBinding
import com.example.countries.domain.model.CountryItem
import com.example.countries.ui.adapter.CountriesAdapter
import com.example.countries.viewmodel.CountryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
       private lateinit var binding: ActivityMainBinding
       private val viewmodel : CountryViewModel by viewModels()
    private lateinit var adapter: CountriesAdapter
    private var myCountryList = mutableListOf<CountryItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView ( binding.root )
        viewmodel.getAll()
        initRV()
        viewmodel.myList.observe(this){
            myCountryList.clear()
            myCountryList.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }
    private fun initRV() {
        adapter = CountriesAdapter(myCountryList)
        binding.rvCountries.layoutManager = LinearLayoutManager(this)
        binding.rvCountries.adapter = adapter
    }
}
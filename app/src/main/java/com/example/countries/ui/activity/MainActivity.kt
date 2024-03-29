package com.example.countries.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countries.databinding.ActivityMainBinding
import com.example.countries.domain.model.CountryItem
import com.example.countries.ui.ResultState
import com.example.countries.ui.adapter.CountriesAdapter
import com.example.countries.viewmodel.CountryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewmodel: CountryViewModel by viewModels()
    private lateinit var adapter: CountriesAdapter
    private var myCountryList = mutableListOf<CountryItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewmodel.getAll()
        initRV()

        viewmodel.state.observe(this) { state ->
            when (state) {
                is ResultState.ERROR -> {
                    Log.d("TAJ", "error clase Error")
                    binding.progressCircular.isVisible = false
                }

                is ResultState.ERROR_CONECTION -> {
                    binding.progressCircular.isVisible = false
                    Log.d("TAJ", "error clase Error conecction")
                    Toast.makeText(this, state.error, Toast.LENGTH_SHORT).show()
                }

                ResultState.LOADING -> binding.progressCircular.isVisible = true
                is ResultState.SUCCESS -> {
                    Log.d("TAJ", "error clase Sucess")
                    binding.progressCircular.isVisible = false
                    myCountryList.clear()
                    myCountryList.addAll(state.results)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    private fun initRV() {
        adapter = CountriesAdapter(myCountryList)
        binding.rvCountries.layoutManager = LinearLayoutManager(this)
        binding.rvCountries.adapter = adapter
    }
}
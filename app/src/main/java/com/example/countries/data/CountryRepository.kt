package com.example.countries.data

import com.example.countries.data.network.CountryService
import com.example.countries.domain.model.CountryItem
import com.example.countries.domain.model.toDomain
import javax.inject.Inject

class CountryRepository @Inject constructor(private val service: CountryService) {

    suspend fun getAll():List<CountryItem>{
        val response = service.getAll()
        return response.map {
            it.toDomain()
        }
    }
}
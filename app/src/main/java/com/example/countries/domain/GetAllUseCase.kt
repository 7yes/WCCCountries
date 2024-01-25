package com.example.countries.domain

import com.example.countries.data.CountryRepository
import com.example.countries.domain.model.CountryItem
import javax.inject.Inject

class GetAllUseCase @Inject constructor(private val repo: CountryRepository) {
    suspend fun getAll():List<CountryItem> = repo.getAll()
}
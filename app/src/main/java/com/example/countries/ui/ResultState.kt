package com.example.countries.ui

import com.example.countries.domain.model.CountryItem

sealed class ResultState {
        object LOADING : ResultState()
        class SUCCESS(val results: List<CountryItem>) : ResultState()
        class ERROR(val error: Throwable) : ResultState()
        class ERROR_CONECTION(val error: String) : ResultState()
}
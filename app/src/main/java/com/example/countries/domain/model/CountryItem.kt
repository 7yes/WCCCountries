package com.example.countries.domain.model

import com.example.countries.data.model.CountryResponseItem

data class CountryItem(
    val capital: String,
    val code: String,
    val flag: String,
    val name: String,
    val region: String
)

fun CountryResponseItem.toDomain()= CountryItem(capital, code, flag, name, region)
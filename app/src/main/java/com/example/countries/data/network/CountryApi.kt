package com.example.countries.data.network

import com.example.countries.data.model.CountryResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface CountryApi {
    @GET("countries.json")
    suspend fun getAll():Response<ArrayList<CountryResponseItem>>
}
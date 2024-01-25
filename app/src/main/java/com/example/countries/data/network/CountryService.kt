package com.example.countries.data.network

import android.util.Log
import com.example.countries.data.model.CountryResponseItem
import retrofit2.http.GET
import javax.inject.Inject

class CountryService @Inject constructor(private val api:CountryApi){

    @GET
    suspend fun getAll():List<CountryResponseItem>{

//        val response= api.getAll()
//        val body = response.body()
//        return body?: emptyList<CountryResponseItem>()

        var answer = emptyList<CountryResponseItem>()
        try {
            val response = api.getAll()
            Log.d("TAJ", "No Internet ")
            val body = response.body()
            if (body != null) {
                answer = body
            } else {
                Log.d("TAJ", "error server is off")
            }
        } catch (e: Exception) {
            if (e.message!!.lowercase().contains("unable to resolve")) {
                Log.d("TAJ", "error No internet")
            } else {
                Log.d("TAJ", "unexpected error  ${e.message}")
            }
        }
        return answer
    }

}
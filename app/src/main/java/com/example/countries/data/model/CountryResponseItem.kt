package com.example.countries.data.model

import com.google.gson.annotations.SerializedName

data class CountryResponseItem(
   @SerializedName("capital")  val capital: String,
   @SerializedName("code") val code: String,
   @SerializedName("flag") val flag: String,
   @SerializedName("name") val name: String,
   @SerializedName("region") val region: String
)
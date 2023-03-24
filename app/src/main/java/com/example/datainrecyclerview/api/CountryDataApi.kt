package com.example.datainrecyclerview.api

import com.example.datainrecyclerview.responsemodels.CountryData
import retrofit2.Response
import retrofit2.http.GET

interface CountryDataApi {

    @GET("/mylocalbusiness/getCountries")
    suspend fun getCountryApiData(): Response<CountryData>
}
package com.example.datainrecyclerview.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitInstance {

    val retrofit by lazy{
        Retrofit.Builder().baseUrl("https://bpj.scf.mybluehost.me")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryDataApi::class.java)
    }
}
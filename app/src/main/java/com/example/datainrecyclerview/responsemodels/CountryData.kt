package com.example.datainrecyclerview.responsemodels

import com.example.datainrecyclerview.responsemodels.Data

data class CountryData(
    val data: List<Data>,
    val message: String,
    val status: Int
)
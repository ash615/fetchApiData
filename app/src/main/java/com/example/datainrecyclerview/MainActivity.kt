package com.example.datainrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.datainrecyclerview.adapter.CountryDataAdapter
import com.example.datainrecyclerview.responsemodels.Data
import com.example.datainrecyclerview.api.RetrofitInstance
import com.example.datainrecyclerview.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var reponse : List<Data> ?=null
   lateinit var countryDataAdapter: CountryDataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        callDATA()
        binding?.searchText?.doOnTextChanged { text, _, _, _ ->
            val textToSeatch = text.toString().toLowerCase(Locale.getDefault())
//            filterWithQuery(textToSeatch)
        }
        setContentView(binding?.root)
    }

    private fun callDATA(){
        CoroutineScope(Dispatchers.Main).launch {
            reponse= RetrofitInstance.retrofit.getCountryApiData().body()?.data!!
            //  responsee = Lis
            countryDataAdapter = CountryDataAdapter(reponse!!)
            binding?.rvCountryData?.apply {
                Log.e("reponse", reponse.toString())
                adapter = countryDataAdapter
                layoutManager = LinearLayoutManager(this@MainActivity) }
            Log.e("Response", reponse.toString())
              }
        }
    }

//    private fun filterWithQuery(query: String){
//        if(query.isNotEmpty()){
//            val filteredLIst = reponse.toString().contains(query, false)
//            if(filteredLIst == true){
//                CoroutineScope(Dispatchers.Main).launch {
//                    reponse= RetrofitInstance.retrofit.getCountryApiData().body()?.data!!
//                    //  responsee = Lis
//
//                    countryDataAdapter = CountryDataAdapter(reponse!!)
//                    binding?.rvCountryData?.apply {
//                        Log.e("reponse", reponse.toString())
//                        adapter = countryDataAdapter
//                        layoutManager = LinearLayoutManager(this@MainActivity) }
//                    Log.e("Response", reponse.toString())
//                    countryDataAdapter.onItemClick = {
//                        //
//                    }
//                }
//            }
//            Log.e("filter", filteredLIst.toString())
//        }
//    }


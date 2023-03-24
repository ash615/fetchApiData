package com.example.datainrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.datainrecyclerview.R
import com.example.datainrecyclerview.responsemodels.Data

class CountryDataAdapter(private var data: List<Data>) : RecyclerView.Adapter<CountryDataAdapter.CountryViewHolder>(){
    var onItemClick: ((Data)-> Unit) ?= null

    inner class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val countryname =  view.findViewById<TextView>(R.id.countryName)
        val countrycode = view.findViewById<TextView>(R.id.countryCode)!!
        val imageofcountry = view.findViewById<ImageView>(R.id.countryImage)
        val isCheckedCountry = view.findViewById<CheckBox>(R.id.checkCountry)
        init {
            view.setOnClickListener {
                onItemClick?.invoke(data[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.country_data_preview, parent, false))
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
                 val currItem = data[position]
        holder.countryname.text = currItem.countries_name.toString()
        holder.countrycode.text = currItem.countries_id.toString()
        Glide.with(holder.itemView.context).load(currItem.flag.toString()).into(holder.imageofcountry)
    }

    override fun getItemCount(): Int {
        return  data.size
    }

}
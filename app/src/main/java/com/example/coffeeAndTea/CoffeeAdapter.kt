package com.example.coffeeAndTea

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeAndTea.model.Coffee
import com.example.coffeeAndTea.model.Popular
import com.example.coffee_and_tea.R


class CoffeeAdapter(private var cflist:List<Coffee>):
    RecyclerView.Adapter<CoffeeAdapter.DrinkViewHolder>() {
     class DrinkViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
         var img : ImageView = itemView.findViewById(R.id.image)
         var name : TextView = itemView.findViewById(R.id.textName)


    }
    fun setFilteredList(list: List<Coffee>){
        this.cflist = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item,parent,false)
        return  DrinkViewHolder(view)

    }


    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {

        holder.img.setImageResource(cflist[position].img)
        holder.name.text = cflist[position].name

    }
    override fun getItemCount(): Int {
        return cflist.size
    }
}
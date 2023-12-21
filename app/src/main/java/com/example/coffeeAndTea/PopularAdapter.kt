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

class PopularAdapter constructor(
    private var mList: List<Popular>) :

    RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_popular, parent, false)
        return PopularViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {

        holder.mTextView.text = mList[position].nameM
        holder.mImageView.setImageResource(mList[position].imgM)

    }
    override fun getItemCount(): Int {
        return mList.size
    }

    inner class PopularViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val mTextView: TextView = itemView.findViewById(R.id.text_name)
        val mImageView: ImageView = itemView.findViewById(R.id.image_menu)
    }

}
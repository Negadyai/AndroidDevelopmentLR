package com.example.lr_6.recadapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lr_6.API.Quotes
import com.example.lr_6.R

class StateRecycler(val context : Context, val quotes: Quotes) : RecyclerView.Adapter<StateRecycler.StateHolder>() {
    class StateHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image : ImageView = itemView.findViewById(R.id.im_state)
        val titleText : TextView = itemView.findViewById(R.id.titleText_state)
        val stateText : TextView = itemView.findViewById(R.id.stateText_state)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.state_adapter, parent, false)
        return StateHolder(root)
    }

    override fun getItemCount(): Int {
        return quotes.data.size
    }

    override fun onBindViewHolder(holder: StateHolder, position: Int) {
        Glide.with(context).load(quotes.data[position].image).into(holder.image)
        holder.titleText.setText(quotes.data[position].title)
        holder.stateText.setText(quotes.data[position].description)
        Log.d("State", holder.image.toString())
    }
}
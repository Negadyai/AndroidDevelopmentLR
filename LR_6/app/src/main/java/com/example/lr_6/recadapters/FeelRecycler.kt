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
import com.example.lr_6.API.Feelings
import com.example.lr_6.R

class FeelRecycler(val context : Context, val feelings: Feelings) : RecyclerView.Adapter<FeelRecycler.FeelHolder>() {
    class FeelHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        val image : ImageView = itemView.findViewById(R.id.img_feel)
        val textView : TextView = itemView.findViewById(R.id.text_feel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeelRecycler.FeelHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.feel_adapter, parent, false)
        return FeelHolder(root)
    }

    override fun getItemCount(): Int {
        return feelings.data.size
    }

    override fun onBindViewHolder(holder: FeelRecycler.FeelHolder, position: Int) {
        Glide.with(context).load(feelings.data[position].image).into(holder.image)
        holder.textView.setText(feelings.data[position].title)
        Log.d("Feel", holder.textView.text.toString())
    }


}
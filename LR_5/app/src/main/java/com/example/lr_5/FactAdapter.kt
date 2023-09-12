package com.example.lr_5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lr_5.databinding.FactItemBinding

class FactAdapter : RecyclerView.Adapter<FactAdapter.FactHolder>() {
    val factList = ArrayList<Fact>()
    class FactHolder(item : View) : RecyclerView.ViewHolder(item) {
        val binding = FactItemBinding.bind(item)
        fun bind(fact: Fact){
            binding.factTv.text = fact.fact
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fact_item, parent, false)
        return FactHolder(view)
    }

    override fun getItemCount(): Int {
        return factList.size
    }

    override fun onBindViewHolder(holder: FactHolder, position: Int) {
        holder.bind(factList[position])
    }

    fun AddFact(fact : Fact){
        factList.add(fact)
        notifyDataSetChanged()
    }
}
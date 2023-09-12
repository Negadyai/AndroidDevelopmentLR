package com.example.lr3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lr3.databinding.ActivityHorizontalListBinding
import com.example.lr3.databinding.ActivityMainBinding

class HorizontalListActivity : AppCompatActivity() {
    lateinit var binding: ActivityHorizontalListBinding
    private val adapter = PlantAdapter()
    private val imageIdList = listOf(R.drawable.plant1, R.drawable.plant2, R.drawable.plant3, R.drawable.plant4, R.drawable.plant5)
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHorizontalListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Init()
    }

    private fun Init(){
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@HorizontalListActivity, LinearLayoutManager.HORIZONTAL, false)
            rcView.adapter = adapter
            addPlantButton.setOnClickListener{
                if(index > imageIdList.size - 1) index = 0

                val plant = Plant(imageIdList[index], "Plant $index")
                adapter.AddPlant(plant)
                index++
            }
        }
    }
    fun OpenVerticalList(view: View){
        var intent = Intent(this@HorizontalListActivity, VerticalListActivity::class.java)
        startActivity(intent)
    }
    fun OpenMainActivity(view: View){
        var intent = Intent(this@HorizontalListActivity, MainActivity::class.java)
        startActivity(intent)
    }
}
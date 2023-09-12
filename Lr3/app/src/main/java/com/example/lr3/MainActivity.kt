package com.example.lr3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lr3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
    private val imageIdList = listOf(R.drawable.plant1, R.drawable.plant2, R.drawable.plant3, R.drawable.plant4, R.drawable.plant5)

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Init()
    }

    private fun Init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rcView.adapter = adapter
            addPlantButton.setOnClickListener{
                if(index > imageIdList.size - 1) index = 0

                val plant = Plant(imageIdList[index], "Plant $index")
                adapter.AddPlant(plant)
                index++
            }
        }
    }

    fun OpenHorizontalList(view: View){
        val intent = Intent(this@MainActivity, HorizontalListActivity::class.java)
        startActivity(intent)
    }
    fun OpenVerticalList(view: View){
        val intent = Intent(this@MainActivity, VerticalListActivity::class.java)
        startActivity(intent)
    }
}
package com.example.lr3_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var buttonHello : Button
    lateinit var textCounterCrow : TextView
    lateinit var textCountCat : TextView
    var crowCounter : Int = 0
    var catCounter : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonHello = findViewById(R.id.buttonHello)
        textCountCat = findViewById(R.id.textCountCat)
        textCounterCrow = findViewById(R.id.textCountCrow)
    }
    fun OnClick(view : View){
        Toast.makeText(applicationContext, "Hello, i am Toast", Toast.LENGTH_SHORT).show()
    }

    fun OpenTrafficLightActivity(view : View){
        var intent = Intent(this@MainActivity, Semofor::class.java)
        startActivity(intent)
    }
    fun OpenAboutActivity(view: View){
        var intent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(intent)
    }

    fun OnCountCrow(view : View){
        textCounterCrow.text = "Я насчитал ${++crowCounter} ворон"

        if(crowCounter == catCounter){
            crowCounter = 0
            textCounterCrow.text = "Я насчитал 0 ворон"
            Toast.makeText(applicationContext, "Вороны улетели", Toast.LENGTH_SHORT).show()
        }

    }

    fun OnCountCat(view: View){
        textCountCat.text = "Я насчитал ${++catCounter} котов"

        if(crowCounter == catCounter * 2){
            textCountCat.text = "Я насчитал 0 котов"
            catCounter = 0
            Toast.makeText(applicationContext, "Коты убежали", Toast.LENGTH_SHORT).show()
        }

    }

}
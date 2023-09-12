package com.example.lr3_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class AboutActivity : AppCompatActivity() {
    lateinit var aboutMeText : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    fun OpenMainActivity(view : View){
        var intent = Intent(this@AboutActivity, MainActivity::class.java)
        startActivity(intent)
    }

    fun OpenTrafficLightActivity(view: View){
        var intent = Intent(this@AboutActivity, Semofor::class.java)
        startActivity(intent)
    }
}
package com.example.lr3_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class Semofor : AppCompatActivity() {
    lateinit var redButton : Button
    lateinit var rootLayout : ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semofor)
        redButton = findViewById(R.id.redButton)
        rootLayout = findViewById(R.id.root_layout)
    }

    fun OpenMainActivity(view: View){
        var intent = Intent(this@Semofor, MainActivity::class.java)
        startActivity(intent)
    }
    fun OpenAboutActivity(view: View){
        var intent = Intent(this@Semofor, AboutActivity::class.java)
        startActivity(intent)
    }

    fun OnClickRed(view: View){
        rootLayout.setBackgroundColor(resources.getColor(R.color.red))
        Toast.makeText(applicationContext, "Стой!", Toast.LENGTH_SHORT).show()
    }
    fun OnClickYellow(view: View){
        rootLayout.setBackgroundColor(resources.getColor(R.color.yellow))
        Toast.makeText(applicationContext, "Готовься!", Toast.LENGTH_SHORT).show()
    }
    fun OnClickGreen(view: View){
        rootLayout.setBackgroundColor(resources.getColor(R.color.green))
        Toast.makeText(applicationContext, "Ехай!", Toast.LENGTH_SHORT).show()
    }
}
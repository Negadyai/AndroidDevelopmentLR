package com.example.lr_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lr_5.databinding.ActivityMainBinding
import okhttp3.*
import okio.IOException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    val url = "https://api.chucknorris.io/jokes/random"
    val okHttpClient : OkHttpClient = OkHttpClient()
    lateinit var binding: ActivityMainBinding
    lateinit var tvFact: TextView

    private val factList = ArrayList<String>()

    private val adapter = FactAdapter()
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
            addFactButton.setOnClickListener{
                val request : Request = Request.Builder().url(url).build()

                okHttpClient.newCall(request).enqueue(object : Callback{

                    override fun onFailure(call: Call, e: IOException) {

                    }

                    override fun onResponse(call: Call, response: Response) {
                        val json = response.body.string()
                        val txt = (JSONObject(json).get("value")).toString()

                        runOnUiThread{
                            val  fact = Fact(txt)
                            adapter.AddFact(fact)
                        }
                    }
                })


                index++
            }
        }
    }
}
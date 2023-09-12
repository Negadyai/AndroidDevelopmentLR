package com.example.lr_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.lr_6.API.GetApi
import com.example.lr_6.API.Login
import com.example.lr_6.API.MyRetrofit
import retrofit2.Call
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    lateinit var email : EditText
    lateinit var password : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
    }

    fun signIn(view : View){
        if(email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty())
        {
            val log = MyRetrofit().GetRetrofit()
            Log.d("Check", log.toString())
            val getApi = log.create(GetApi::class.java)
            var hashMap: HashMap<String, String> = HashMap<String, String>()
            hashMap.put("email", email.text.toString())
            hashMap.put("password", password.text.toString())
            val logCall:retrofit2.Call<Login> = getApi.GetAuth(hashMap)
            logCall.enqueue(object : retrofit2.Callback<Login>{
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    if (response.isSuccessful){
                        val intent = Intent(this@SignInActivity, MenuActivity::class.java)
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<Login>, t: Throwable) {
                    Log.d("Check", call.toString())
                    Toast.makeText(this@SignInActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("У вас есть незаполненные поля")
                .setPositiveButton("Ok", null)
                .create()
                .show()
        }
    }
}
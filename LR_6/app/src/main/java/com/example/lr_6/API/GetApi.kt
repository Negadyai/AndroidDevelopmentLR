package com.example.lr_6.API

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface GetApi {
    @POST("user/login/")
    fun GetAuth(@Body hashMap: HashMap<String, String>): Call<Login>
    @GET("feelings")
    fun GetFeel():Call<Feelings>
    @GET("quotes")
    fun GetQuotes():Call<Quotes>
}

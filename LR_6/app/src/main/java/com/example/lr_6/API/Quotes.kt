package com.example.lr_6.API

data class Quotes(val success : Boolean, val data : ArrayList<DataQuotes>)
data class DataQuotes(val id : Int, val title : String, val image : String, val description : String)
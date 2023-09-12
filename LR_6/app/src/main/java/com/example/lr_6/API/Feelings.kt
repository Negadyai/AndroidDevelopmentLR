package com.example.lr_6.API

data class Feelings(val success : Boolean, val data : ArrayList<DataFeelings>)
data class DataFeelings(val id : Int, val title : String, val image : String, val position : Int)

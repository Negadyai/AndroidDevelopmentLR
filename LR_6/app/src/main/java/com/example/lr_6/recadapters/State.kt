package com.example.lr_6.recadapters

import com.example.lr_6.R

data class State(val title: String, val textState : String, val imageState : Int)
class MyState(){
    val stateList = arrayListOf(
        State("Заголовок статьи", "Краткое описание", R.drawable.state_1),
        State("Заголовок статьи", "Краткое описание", R.drawable.state_2)
    )
}

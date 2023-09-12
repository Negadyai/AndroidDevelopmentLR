package com.example.lr_6

data class Feel(val image : Int, val nameFeel : String)
class MyFeel{ val list = arrayListOf(Feel(R.drawable.calm_img, "Спокойным"),
    Feel(R.drawable.relax_img, "Расслабленным"),
    Feel(R.drawable.focus_img, "Сосредоточенным"),
    Feel(R.drawable.anxious_img, "Взволнованным")
    )
}

package com.example.mad_02_layout_and_databinding.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("mapListToString")
fun bindMapListToString(view: TextView, list: MutableList<String>?) {
    when(list){
        null -> view.text = ""
        else -> {
            var textString = ""

            for((idx, el) in list.withIndex()){
                if(idx != 0){
                    textString += ", "
                }
                textString += el
            }

            view.text = textString
        }
    }
}
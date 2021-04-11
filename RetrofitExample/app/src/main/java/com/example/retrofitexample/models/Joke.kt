package com.example.retrofitexample.models

import com.google.gson.annotations.SerializedName

data class Joke(
    val id: Int,
    @SerializedName("type")   // with SerializedName annotation variable names can be overwritten - if not used the json keys will be used
    val typeOfJoke: String,
    val setup: String,
    val punchline: String
)
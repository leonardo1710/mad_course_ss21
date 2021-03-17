package com.example.mad_02_layout_and_databinding.models

data class Movie(
    var title: String = "",
    var description: String = ""
) {
    var rating: Float = 0.0F
        set(value) {
            if(value in 0.0..5.0) field = value
            else throw IllegalArgumentException("Rating value must be between 0 and 5")
        }
    var actors: MutableList<String> = mutableListOf()
    var creators: MutableList<String> = mutableListOf()
    var genres: List<String>? = null
}
package com.example.retrofitexample.api

import com.example.retrofitexample.models.Joke
import retrofit2.http.GET

interface ApiService {

    @GET("random_joke")
    suspend fun getJoke(): Joke

}
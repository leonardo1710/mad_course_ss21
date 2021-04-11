package com.example.retrofitexample.repositories

import com.example.retrofitexample.api.RetrofitBuilder.apiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class JokeRepository {
    suspend fun getRandomJoke() = withContext(Dispatchers.IO) {
        apiService.getJoke()
    }
}
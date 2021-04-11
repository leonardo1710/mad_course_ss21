package com.example.retrofitexample.viewmodels

import androidx.lifecycle.*
import com.example.retrofitexample.models.Joke
import com.example.retrofitexample.repositories.JokeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val repository = JokeRepository()

    private val _randomJoke = MutableLiveData<Joke>()
    val randomJoke: LiveData<Joke>
        get() = _randomJoke

    init {
        getNewRandomJoke()
    }

    fun getNewRandomJoke(){
        viewModelScope.launch(Dispatchers.Main) {
            _randomJoke.value = repository.getRandomJoke()
        }
    }
}
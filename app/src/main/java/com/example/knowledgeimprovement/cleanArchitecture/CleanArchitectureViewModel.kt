package com.example.knowledgeimprovement.cleanArchitecture

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.MovieDomain
import kotlinx.coroutines.launch

class CleanArchitectureViewModel(private val useCases: UseCases) : ViewModel(){
    val movies = MutableLiveData<List<MovieDomain>>()

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            val movieList = useCases.getMovies() ?: return@launch
            movies.postValue(movieList)
        }
    }
}
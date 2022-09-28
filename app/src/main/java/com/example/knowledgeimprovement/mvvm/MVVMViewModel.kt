package com.example.knowledgeimprovement.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.knowledgeimprovement.model.domain.MovieDomainModel
import com.example.knowledgeimprovement.utils.toMovieDomainModel
import kotlinx.coroutines.launch

class MVVMViewModel : ViewModel() {
    private val repository by lazy { MVVMRepository() }
    val movies = MutableLiveData<List<MovieDomainModel>>()

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            val movieList = repository.getMovies() ?: return@launch
            movies.postValue(movieList.map { it.toMovieDomainModel() })
        }
    }
}
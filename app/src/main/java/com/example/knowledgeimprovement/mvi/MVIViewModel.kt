package com.example.knowledgeimprovement.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.knowledgeimprovement.utils.toMovieDomainModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class MVIViewModel : ViewModel() {
    private val repository: MVIRepository by lazy { MVIRepository() }
    val intent = Channel<MVIIntent>()
    private val _state = MutableStateFlow<MVIState>(MVIState.InitialState)
    val state get() = _state

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            intent.consumeAsFlow().collect {
                when (it) {
                    MVIIntent.GetMovieList -> getMovies()
                }
            }
        }
    }

    fun sendIntent(intent: MVIIntent) {
        viewModelScope.launch {
            this@MVIViewModel.intent.send(intent)
        }
    }

    private fun getMovies() {
        viewModelScope.launch {
            _state.value = MVIState.Loading
            val movies = repository.getMovies()?.map { it.toMovieDomainModel() }
            _state.value = if (movies != null) {
                MVIState.ListLoadedSuccess(movies)
            } else {
                MVIState.ListLoadedError("movies are null")
            }
            _state.value = MVIState.StopLoading
        }
    }
}
package com.example.knowledgeimprovement.mvi

import com.example.knowledgeimprovement.model.domain.MovieDomainModel

sealed class MVIState {
    object InitialState : MVIState()
    object Loading : MVIState()
    object StopLoading : MVIState()
    class ListLoadedSuccess(val movies : List<MovieDomainModel>) : MVIState()
    class ListLoadedError(val error : String) : MVIState()
}
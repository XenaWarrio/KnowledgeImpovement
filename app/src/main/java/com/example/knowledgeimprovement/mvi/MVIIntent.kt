package com.example.knowledgeimprovement.mvi

sealed class MVIIntent {
    object GetMovieList : MVIIntent()
}
package com.example.knowledgeimprovement.app

import android.app.Application
import com.example.core.MovieRepository
import com.example.core.useCases.GetMovies
import com.example.knowledgeimprovement.cleanArchitecture.MovieDataSourceImpl
import com.example.knowledgeimprovement.cleanArchitecture.UseCases

class KnowledgeImprovementApp : Application() {
    private val movieRepository by lazy { MovieRepository(MovieDataSourceImpl()) }
    val useCases by lazy { UseCases(GetMovies(movieRepository)) }
}
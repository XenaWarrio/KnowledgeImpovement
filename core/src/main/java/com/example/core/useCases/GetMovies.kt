package com.example.core.useCases

import com.example.core.MovieRepository
import com.example.core.domain.MovieDomain

class GetMovies(private val repository: MovieRepository) {
    suspend operator fun invoke(): List<MovieDomain>?{
        return repository.getMovies()
    }
}
package com.example.core

import com.example.core.domain.MovieDomain

interface MovieDataSource {
    suspend fun getMovies() : List<MovieDomain>?
}
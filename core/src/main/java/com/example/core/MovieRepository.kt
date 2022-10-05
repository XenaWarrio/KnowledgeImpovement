package com.example.core

import com.example.core.domain.MovieDomain

class MovieRepository (private val movieDataSource: MovieDataSource) {
   suspend fun getMovies(): List<MovieDomain>?{
       return movieDataSource.getMovies()
   }
}
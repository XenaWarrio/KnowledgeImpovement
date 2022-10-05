package com.example.knowledgeimprovement.cleanArchitecture

import com.example.core.MovieDataSource
import com.example.core.domain.MovieDomain
import com.example.knowledgeimprovement.api.ApiInterface
import com.example.knowledgeimprovement.api.RetrofitClient
import com.example.knowledgeimprovement.utils.toMovieDomain

class MovieDataSourceImpl : MovieDataSource {
    override suspend fun getMovies(): List<MovieDomain>? {
        val retrofit = RetrofitClient.getInstance()
        val api = retrofit.create(ApiInterface::class.java)
        val response = api.getMovies("8d96120d087a1a7cf0db4af21ce925a6")
        return response.body()?.results?.map { it.toMovieDomain() }
    }
}
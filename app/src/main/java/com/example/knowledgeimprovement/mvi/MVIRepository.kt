package com.example.knowledgeimprovement.mvi

import com.example.knowledgeimprovement.api.ApiInterface
import com.example.knowledgeimprovement.api.RetrofitClient
import com.example.knowledgeimprovement.model.network.MovieResponse

class MVIRepository {
    suspend fun getMovies(): List<MovieResponse>? {
        val retrofit = RetrofitClient.getInstance()
        val api = retrofit.create(ApiInterface::class.java)
        val response = api.getMovies("8d96120d087a1a7cf0db4af21ce925a6")
        return response.body()?.results
    }
}
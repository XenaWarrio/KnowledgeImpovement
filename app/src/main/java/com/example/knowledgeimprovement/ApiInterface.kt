package com.example.knowledgeimprovement

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("discover/movie")
   suspend fun getMovies(@Query("api_key") apiKey : String, ) : Response<Results>
}
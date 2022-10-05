package com.example.knowledgeimprovement.model.network

import com.google.gson.annotations.SerializedName

data class Results(@SerializedName("results") var results: List<MovieResponse>)
data class MovieResponse(
    @SerializedName("original_title") var title: String
)
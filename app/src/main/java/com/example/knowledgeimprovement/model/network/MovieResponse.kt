package com.example.knowledgeimprovement

import com.google.gson.annotations.SerializedName

data class Results(@SerializedName("results") var results: List<MovieResponse>)
data class MovieResponse(
    @SerializedName("original_title") var title: String
)
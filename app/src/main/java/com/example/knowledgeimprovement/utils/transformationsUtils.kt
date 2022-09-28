package com.example.knowledgeimprovement.utils

import com.example.knowledgeimprovement.MovieResponse
import com.example.knowledgeimprovement.model.domain.MovieDomainModel

fun MovieResponse.toMovieDomainModel() = MovieDomainModel(title = this.title)
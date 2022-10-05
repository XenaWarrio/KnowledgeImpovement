package com.example.knowledgeimprovement.utils

import com.example.core.domain.MovieDomain
import com.example.knowledgeimprovement.model.domain.MovieDomainModel
import com.example.knowledgeimprovement.model.network.MovieResponse

fun MovieResponse.toMovieDomainModel() = MovieDomainModel(title = this.title)
fun MovieResponse.toMovieDomain() = MovieDomain(title = this.title)
fun MovieDomain.toMovieDomainModel() = MovieDomainModel(title = this.title)
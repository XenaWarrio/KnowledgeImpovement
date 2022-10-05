package com.example.knowledgeimprovement.cleanArchitecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CleanArchitectureViewModelFactory (private val useCases: UseCases): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CleanArchitectureViewModel::class.java)) {
            CleanArchitectureViewModel(this.useCases) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
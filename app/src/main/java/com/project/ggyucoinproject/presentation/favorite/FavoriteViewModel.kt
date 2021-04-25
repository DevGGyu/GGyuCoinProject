package com.project.ggyucoinproject.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FavoriteViewModel constructor(private val repository: FavoriteRepository): ViewModel() {

    val favorites = repository.favorites

    fun getFavorites() {
        viewModelScope.launch {
            repository.getFavorites()
        }
    }
}
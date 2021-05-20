package com.project.ggyucoinproject.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: FavoriteRepository): ViewModel() {

    val favorites = repository.favorites

    fun getFavorites() {
        viewModelScope.launch {
            repository.getFavorites()
        }
    }
}
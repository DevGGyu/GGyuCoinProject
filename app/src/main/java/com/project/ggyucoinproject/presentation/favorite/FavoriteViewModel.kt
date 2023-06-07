package com.project.ggyucoinproject.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.ggyucoinproject.domain.usecase.FavoriteUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(private val repository: FavoriteUseCase) : ViewModel() {

    val favorites = repository.favorites

    fun getFavorites() {
        viewModelScope.launch {
            repository.getFavorites()
        }
    }
}
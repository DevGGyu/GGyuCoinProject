package com.project.ggyucoinproject.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.ggyucoinproject.domain.usecase.FavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val useCase: FavoriteUseCase) : ViewModel() {

    val favorites = useCase.favorites

    fun getFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getFavorites()
        }
    }
}
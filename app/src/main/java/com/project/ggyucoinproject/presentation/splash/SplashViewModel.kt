package com.project.ggyucoinproject.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.ggyucoinproject.domain.usecase.SplashUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(repository: SplashUseCase): ViewModel() {

    val success = repository.success

    init {
        viewModelScope.launch {
            repository.loadMarketData()
        }
    }
}
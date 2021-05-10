package com.project.ggyucoinproject.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SplashViewModel(repository: SplashRepository): ViewModel() {

    val success = repository.success

    init {
        viewModelScope.launch {
            repository.loadMarketData()
        }
    }
}
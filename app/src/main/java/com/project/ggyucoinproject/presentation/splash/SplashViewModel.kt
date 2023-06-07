package com.project.ggyucoinproject.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.ggyucoinproject.domain.usecase.SplashUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val useCase: SplashUseCase): ViewModel() {

    val success = useCase.success

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.loadMarketData()
        }
    }
}
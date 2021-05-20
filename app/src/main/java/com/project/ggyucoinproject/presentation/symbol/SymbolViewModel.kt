package com.project.ggyucoinproject.presentation.symbol

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SymbolViewModel @Inject constructor(private val repository: SymbolRepository) : ViewModel() {

    val marketAll = repository.marketAll

    init {
        viewModelScope.launch {
            repository.getMarketAll()
        }
    }
}
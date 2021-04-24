package com.project.ggyucoinproject.presentation.symbol

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SymbolViewModel constructor(private val repository: SymbolRepository) : ViewModel() {

    val marketAll = repository.marketAll

    init {
        getMarketAll()
    }

    private fun getMarketAll() {
        viewModelScope.launch {
            repository.getMarketAll()
        }
    }
}
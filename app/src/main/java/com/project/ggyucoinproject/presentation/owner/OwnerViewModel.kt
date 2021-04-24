package com.project.ggyucoinproject.presentation.owner

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class OwnerViewModel constructor(private val repository: OwnerRepository) : ViewModel() {

    val domains = repository.domains

    init {
        loadMarketInfo()
    }

    private fun loadMarketInfo() {
        viewModelScope.launch {
            repository.getCoinList()
        }
    }
}
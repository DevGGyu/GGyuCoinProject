package com.project.ggyucoinproject.presentation.owner

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.ggyucoinproject.domain.CoinDomain
import kotlinx.coroutines.launch

class OwnerViewModel constructor(private val repository: OwnerRepository) : ViewModel() {

    val domains: LiveData<List<CoinDomain>> = repository.domains

    val bitcoin: LiveData<CoinDomain> = Transformations.map(domains) { coins ->
        coins.find { it.market == "KRW-BTC" }
    }

    init {
        loadMarketInfo()
    }

    private fun loadMarketInfo() {
        viewModelScope.launch {
            repository.getCoinList()
        }
    }
}
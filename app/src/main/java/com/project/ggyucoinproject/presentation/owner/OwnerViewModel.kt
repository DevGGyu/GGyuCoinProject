package com.project.ggyucoinproject.presentation.owner

import androidx.lifecycle.*
import com.project.ggyucoinproject.domain.CoinDomain
import kotlinx.coroutines.launch
import java.util.*

class OwnerViewModel constructor(private val repository: OwnerRepository) : ViewModel() {

    val domains: LiveData<List<CoinDomain>> = Transformations.map(repository.domains) { coins ->
        val filter = query.value
        if (filter.isNullOrEmpty()) coins
        else coins.filter { it.market.contains(filter.toUpperCase(Locale.getDefault())) }
    }

    val query = MutableLiveData<String>()

    val bitcoin: LiveData<CoinDomain> = Transformations.map(repository.domains) { coins ->
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
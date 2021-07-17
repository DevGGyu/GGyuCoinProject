package com.project.ggyucoinproject.presentation.owner

import androidx.lifecycle.*
import com.project.ggyucoinproject.domain.CoinDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class OwnerViewModel @Inject constructor(private val repository: OwnerRepository) : ViewModel() {

    val domainList: LiveData<List<CoinDomain>> = Transformations.map(repository.domainList) { coins ->
        val filter = query.value
        if (filter.isNullOrEmpty()) coins
        else coins.filter { it.market.contains(filter.uppercase(Locale.getDefault())) }
    }

    val query = MutableLiveData<String>()

    val bitcoin: LiveData<CoinDomain> = Transformations.map(repository.domainList) { coins ->
        coins.find { it.market == "KRW-BTC" }
    }

    init {
        viewModelScope.launch {
            repository.getCoinList()
        }
    }
}
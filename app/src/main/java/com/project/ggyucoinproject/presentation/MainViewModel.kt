package com.project.ggyucoinproject.presentation

import androidx.lifecycle.*
import com.project.ggyucoinproject.domain.model.CoinDomain
import com.project.ggyucoinproject.domain.usecase.OwnerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: OwnerUseCase) : ViewModel() {

    val domainList: LiveData<List<CoinDomain>> = Transformations.map(useCase.domainList) { coins ->
        val filter = query.value
        if (filter.isNullOrEmpty()) coins
        else coins.filter { it.market.contains(filter.uppercase(Locale.getDefault())) }
    }

    val query = MutableLiveData<String>()

    val bitcoin: LiveData<CoinDomain> = Transformations.map(useCase.domainList) { coins ->
        coins.find { it.market == "KRW-BTC" }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.loadMarketData()
        }
    }
}
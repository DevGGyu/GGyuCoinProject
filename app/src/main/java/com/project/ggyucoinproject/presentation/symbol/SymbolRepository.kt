package com.project.ggyucoinproject.presentation.symbol

import androidx.lifecycle.MutableLiveData
import com.project.ggyucoinproject.data.MarketData
import com.project.ggyucoinproject.domain.MarketDomain
import com.project.ggyucoinproject.etc.api.MarketService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SymbolRepository @Inject constructor(private val service: MarketService) {

    val marketAll = MutableLiveData<List<MarketDomain>>()

    suspend fun getMarketAll() {
        service.getMarketAll().body()?.apply {
            val data = this.distinctBy(MarketData::koreanName).toList()
            val domains = data.map(MarketData::toDomainModel)
            marketAll.postValue(domains)
        }
    }
}
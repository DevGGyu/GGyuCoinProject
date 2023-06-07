package com.project.ggyucoinproject.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.project.ggyucoinproject.common.MarketService
import com.project.ggyucoinproject.data.model.MarketData
import com.project.ggyucoinproject.domain.model.MarketDomain
import javax.inject.Inject

class SymbolUseCase @Inject constructor(private val service: MarketService) {

    val marketAll = MutableLiveData<List<MarketDomain>>()

    suspend fun getMarketAll() {
        service.getMarketAll().body()?.apply {
            val data = this.distinctBy(MarketData::koreanName).toList()
            val domains = data.map(MarketData::toDomainModel)
            marketAll.postValue(domains)
        }
    }
}
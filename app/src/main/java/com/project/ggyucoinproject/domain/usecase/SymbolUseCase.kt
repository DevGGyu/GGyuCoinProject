package com.project.ggyucoinproject.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.project.ggyucoinproject.data.model.MarketData
import com.project.ggyucoinproject.domain.model.MarketDomain
import com.project.ggyucoinproject.domain.repository.MainRepository
import javax.inject.Inject

class SymbolUseCase @Inject constructor(private val repository: MainRepository) {

    val marketAll = MutableLiveData<List<MarketDomain>>()

    suspend fun getMarketAll() {
        repository.getMarketAll()?.apply {
            val data = this.distinctBy(MarketData::koreanName).toList()
            val domains = data.map(MarketData::toDomainModel)
            marketAll.postValue(domains)
        }
    }
}
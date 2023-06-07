package com.project.ggyucoinproject.domain.usecase

import androidx.lifecycle.MutableLiveData
import androidx.viewbinding.BuildConfig
import com.project.ggyucoinproject.common.MainDatabase
import com.project.ggyucoinproject.data.entity.MarketEntity
import com.project.ggyucoinproject.data.model.MarketData
import com.project.ggyucoinproject.data.model.TickerMarketData
import com.project.ggyucoinproject.domain.model.CoinDomain
import com.project.ggyucoinproject.domain.repository.MainRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class OwnerUseCase @Inject constructor(
    private val repository: MainRepository,
    private val mainDB: MainDatabase
) {

    val domainList = MutableLiveData<List<CoinDomain>>()

    suspend fun loadMarketData() {
        val domains = repository.getMarketAll()
            ?.map(MarketData::toEntityModel) ?: return

        repeat(Int.MAX_VALUE) {
            getTickerMarket(domains)
            val timeMillis = if (BuildConfig.DEBUG) 1000L else 10000L
            delay(timeMillis = timeMillis)
        }
    }

    private suspend fun getMarketAll(): List<MarketEntity> = mainDB.marketDao().getAll()

    private suspend fun getTickerMarket(entities: List<MarketEntity>) {
        val coins = mutableListOf<CoinDomain>()

        val newList = entities.subList(0, 10)

        val markets = newList.map(MarketEntity::market).joinToString()

        val tickerMarketDomains = repository.getTickerMarket(markets)
            ?.map(TickerMarketData::toDomainModel) ?: return

        entities.zip(tickerMarketDomains).asFlow().collect { data ->
            val coin = CoinDomain(data.first, data.second)
            coins.add(coin)
        }

        domainList.postValue(coins)
    }
}
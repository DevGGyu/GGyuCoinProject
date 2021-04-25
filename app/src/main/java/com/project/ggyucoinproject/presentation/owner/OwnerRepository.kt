package com.project.ggyucoinproject.presentation.owner

import androidx.lifecycle.MutableLiveData
import com.project.ggyucoinproject.data.MarketData
import com.project.ggyucoinproject.data.TickerMarketData
import com.project.ggyucoinproject.domain.CoinDomain
import com.project.ggyucoinproject.domain.MarketDomain
import com.project.ggyucoinproject.etc.api.MarketService
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect

class OwnerRepository constructor(private val service: MarketService) {

    val domains = MutableLiveData<List<CoinDomain>>()

    suspend fun getCoinList() {
        repeat(Int.MAX_VALUE) {
            coroutineScope {
                val marketAll = async { getMarketAll() }
                val ticker = async { getTickerMarket(marketAll.await()) }
                ticker.await()
            }
            delay(1000)
        }
    }

    private suspend fun getMarketAll(): List<MarketDomain> {
        return service.getMarketAll().map(MarketData::toDomainModel)
    }

    private suspend fun getTickerMarket(marketList: List<MarketDomain>) {
        val coins = mutableListOf<CoinDomain>()
        val markets = marketList.map { it.market }.toList()
        val tickerMarketDomains = service.getTickerMarket(markets)
            .map(TickerMarketData::toDomainModel)
        marketList.zip(tickerMarketDomains).asFlow().collect { data ->
            val coin = CoinDomain(data.first, data.second)
            coins.add(coin)
        }
        domains.postValue(coins)
    }
}
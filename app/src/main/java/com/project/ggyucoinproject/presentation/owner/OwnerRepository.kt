package com.project.ggyucoinproject.presentation.owner

import androidx.lifecycle.MutableLiveData
import com.project.ggyucoinproject.data.MarketData
import com.project.ggyucoinproject.domain.CoinDomain
import com.project.ggyucoinproject.domain.MarketDomain
import com.project.ggyucoinproject.etc.api.MarketService
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

class OwnerRepository constructor(private val service: MarketService) {

    val domains = MutableLiveData<List<CoinDomain>>()

    suspend fun getCoinList() {
        repeat(Int.MAX_VALUE) {
            coroutineScope {
                val marketAll = async { getMarketAll() }
                val ticker = async { getTickerMarket(marketAll.await()) }
                ticker.await()
            }
            delay(10000)
        }
    }

    suspend fun getMarketAll(): List<MarketDomain> {
        return service.getMarketAll().map(MarketData::toDomainList)
    }

    suspend fun getTickerMarket(marketList: List<MarketDomain>) {
        val coins = mutableListOf<CoinDomain>()
        val list = marketList.subList(0, 10)
        list.forEach { market ->
            service.getTickerMarket(market.market)
                .map { data -> data.toDomainModel() }
                .also { ticker ->
                    val coin = CoinDomain(market, ticker[0])
                    coins.add(coin)
                }
        }
        domains.postValue(coins)
    }
}
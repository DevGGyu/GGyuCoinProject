package com.project.ggyucoinproject.presentation.owner

import androidx.lifecycle.MutableLiveData
import com.project.ggyucoinproject.BuildConfig
import com.project.ggyucoinproject.data.TickerMarketData
import com.project.ggyucoinproject.domain.CoinDomain
import com.project.ggyucoinproject.entity.MarketEntity
import com.project.ggyucoinproject.etc.api.MarketService
import com.project.ggyucoinproject.etc.db.MainDatabase
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OwnerRepository @Inject constructor(
    private val service: MarketService,
    private val mainDB: MainDatabase
) {

    val domainList = MutableLiveData<List<CoinDomain>>()

    suspend fun getCoinList() {
        coroutineScope {
            val marketAll = async { getMarketAll() }
            val marketEntities = marketAll.await()

            repeat(Int.MAX_VALUE) {
                val ticker = async { getTickerMarket(marketEntities) }
                ticker.await()
                val timeMillis = if (BuildConfig.DEBUG) 1000L else 10000L
                delay(timeMillis = timeMillis)
            }
        }
    }

    private suspend fun getMarketAll(): List<MarketEntity> = mainDB.marketDao().getAll()

    private suspend fun getTickerMarket(entities: List<MarketEntity>) {
        coroutineScope {
            val ticker = async {
                val coins = mutableListOf<CoinDomain>()

                val markets = entities.map(MarketEntity::market).toList()

                val tickerMarketDomains = service.getTickerMarket(markets).body()
                    ?.map(TickerMarketData::toDomainModel) ?: return@async

                entities.zip(tickerMarketDomains).asFlow().collect { data ->
                    val coin = CoinDomain(data.first, data.second)
                    coins.add(coin)
                }

                domainList.postValue(coins)
            }
            ticker.await()
        }
    }
}
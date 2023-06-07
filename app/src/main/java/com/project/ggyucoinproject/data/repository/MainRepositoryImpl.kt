package com.project.ggyucoinproject.data.repository

import com.project.ggyucoinproject.common.MarketService
import com.project.ggyucoinproject.data.model.MarketData
import com.project.ggyucoinproject.data.model.TickerMarketData
import com.project.ggyucoinproject.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val service: MarketService) : MainRepository {

    override suspend fun getMarketAll(): List<MarketData>? {
        return service.getMarketAll().body()
    }

    override suspend fun getTickerMarket(markets: String): List<TickerMarketData>? {
        return service.getTickerMarket(markets).body()
    }
}
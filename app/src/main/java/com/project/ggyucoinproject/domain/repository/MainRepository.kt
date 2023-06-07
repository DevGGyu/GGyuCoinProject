package com.project.ggyucoinproject.domain.repository

import com.project.ggyucoinproject.data.model.MarketData
import com.project.ggyucoinproject.data.model.TickerMarketData

interface MainRepository {

    suspend fun getMarketAll(): List<MarketData>?

    suspend fun getTickerMarket(markets: String): List<TickerMarketData>?
}
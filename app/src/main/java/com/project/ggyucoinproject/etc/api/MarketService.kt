package com.project.ggyucoinproject.etc.api

import com.project.ggyucoinproject.data.MarketData
import com.project.ggyucoinproject.data.TickerMarketData
import retrofit2.http.GET
import retrofit2.http.Path

interface MarketService {

    @GET("market/all")
    suspend fun getMarketAll(): List<MarketData>

    @GET("ticker?markets={market}")
    fun getTickerMarket(
        @Path("market") market: String
    ): List<TickerMarketData>
}
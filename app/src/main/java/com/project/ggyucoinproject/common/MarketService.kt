package com.project.ggyucoinproject.common

import com.project.ggyucoinproject.data.model.MarketData
import com.project.ggyucoinproject.data.model.TickerMarketData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarketService {

    @GET("market/all")
    suspend fun getMarketAll(): Response<List<MarketData>>

    @GET("ticker")
    suspend fun getTickerMarket(
        @Query("markets") markets: String
    ): Response<List<TickerMarketData>>
}
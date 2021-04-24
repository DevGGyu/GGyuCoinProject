package com.project.ggyucoinproject.domain

data class TickerMarketDomain(
    val market: String,
    val tradePrice: String,
    val signedChangePrice: Double,
    val signedChangeRate: Double,
)
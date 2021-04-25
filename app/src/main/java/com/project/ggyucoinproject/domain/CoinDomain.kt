package com.project.ggyucoinproject.domain

class CoinDomain(market: MarketDomain, ticker: TickerMarketDomain) {
    val market: String = market.market
    val name: String = "${market.koreanName}\n(${market.market})"
    val tradePrice: String = ticker.tradePrice
    val changePrice: String = "${ticker.signedChangePrice}\n(${ticker.signedChangeRate})"
    val prevChangePrice: String = "${ticker.signedChangePrice} (${ticker.signedChangeRate})"
}
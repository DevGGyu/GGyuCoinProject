package com.project.ggyucoinproject.domain

import java.text.DecimalFormat

class CoinDomain(market: MarketDomain, ticker: TickerMarketDomain) {

    private val dec = DecimalFormat("#,##0.##")

    val market: String = market.market
    val name: String = "${market.koreanName}\n(${market.market})"
    val tradePrice: String = ticker.tradePrice
    val signedChange: String = "%.2f".format(ticker.signedChangeRate) + "%"
}
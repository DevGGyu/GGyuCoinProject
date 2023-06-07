package com.project.ggyucoinproject.domain.model

data class MarketDomain(
    val market: String,
    val koreanName: String,
    val englishName: String,
) {
    fun currency() = market.substringAfterLast("-")
}
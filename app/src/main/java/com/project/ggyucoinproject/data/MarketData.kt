package com.project.ggyucoinproject.data

import com.project.ggyucoinproject.domain.MarketDomain
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MarketData(
    @Json(name = "market") val market: String,
    @Json(name = "korean_name") val koreanName: String,
    @Json(name = "english_name") val englishName: String,
) {
    fun toDomainList(): MarketDomain {
        return MarketDomain(
            market = this.market,
            koreanName = this.koreanName,
            englishName = this.englishName
        )
    }
}
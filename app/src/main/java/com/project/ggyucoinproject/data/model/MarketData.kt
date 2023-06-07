package com.project.ggyucoinproject.data.model

import com.project.ggyucoinproject.domain.model.MarketDomain
import com.project.ggyucoinproject.data.entity.MarketEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MarketData(
    @Json(name = "market") val market: String,
    @Json(name = "korean_name") val koreanName: String,
    @Json(name = "english_name") val englishName: String,
) {
    fun toDomainModel(): MarketDomain {
        return MarketDomain(
            market = this.market,
            koreanName = this.koreanName,
            englishName = this.englishName
        )
    }

    fun toEntityModel(): MarketEntity {
        return MarketEntity(
            market = this.market,
            koreanName = this.koreanName,
            englishName = this.englishName
        )
    }
}
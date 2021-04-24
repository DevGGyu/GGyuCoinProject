package com.project.ggyucoinproject.presentation.owner

import androidx.lifecycle.MutableLiveData
import com.project.ggyucoinproject.domain.CoinDomain
import com.project.ggyucoinproject.etc.api.MarketService
import kotlinx.coroutines.delay
import org.joda.time.DateTime

class OwnerRepository constructor(private val service: MarketService) {

    val domains = MutableLiveData<List<CoinDomain>>()

    suspend fun getCoinList() {
        repeat(Int.MAX_VALUE) {
            val coins = mutableListOf<CoinDomain>()
            repeat((1..100).count()) { num ->
                val time = DateTime.now().millis
                val coin = CoinDomain("$num: $time", "57382000.0", "2580000.00000000")
                coins.add(coin)
            }
            domains.postValue(coins)
            delay(1000)
        }
    }
}
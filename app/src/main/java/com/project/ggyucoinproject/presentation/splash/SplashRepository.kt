package com.project.ggyucoinproject.presentation.splash

import androidx.lifecycle.MutableLiveData
import com.project.ggyucoinproject.data.MarketData
import com.project.ggyucoinproject.etc.api.MarketService
import com.project.ggyucoinproject.etc.db.MainDatabase
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SplashRepository @Inject constructor(
    private val service: MarketService,
    private val mainDB: MainDatabase
) {

    val success = MutableLiveData<Unit>()

    suspend fun loadMarketData() {
        coroutineScope {
            val marketAll = async {
                val domains = service.getMarketAll().body()
                    ?.map(MarketData::toEntityModel) ?: return@async
                mainDB.marketDao().insertAll(*domains.toTypedArray())
            }
            marketAll.await()
            success.postValue(Unit)
        }
    }
}
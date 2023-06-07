package com.project.ggyucoinproject.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.project.ggyucoinproject.common.MainDatabase
import com.project.ggyucoinproject.common.MarketService
import com.project.ggyucoinproject.data.model.MarketData
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class SplashUseCase @Inject constructor(
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
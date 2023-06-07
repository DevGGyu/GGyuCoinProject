package com.project.ggyucoinproject.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.project.ggyucoinproject.common.MainDatabase
import com.project.ggyucoinproject.data.model.MarketData
import com.project.ggyucoinproject.domain.repository.MainRepository
import javax.inject.Inject

class SplashUseCase @Inject constructor(
    private val repository: MainRepository,
    private val mainDB: MainDatabase
) {

    val success = MutableLiveData<Unit>()

    suspend fun loadMarketData() {
        val domains = repository.getMarketAll()
            ?.map(MarketData::toEntityModel) ?: return
        mainDB.marketDao().insertAll(*domains.toTypedArray())
        success.postValue(Unit)
    }
}
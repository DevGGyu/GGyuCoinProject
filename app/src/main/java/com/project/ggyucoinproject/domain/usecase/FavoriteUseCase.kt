package com.project.ggyucoinproject.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.project.ggyucoinproject.common.MainDatabase
import javax.inject.Inject

class FavoriteUseCase @Inject constructor(private val db: MainDatabase) {

    val favorites = MutableLiveData<List<String>>()

    suspend fun getFavorites() {
        val favoriteMarkets = db.favoriteDao().getAll().map { it.market }.toList()
        favorites.postValue(favoriteMarkets)
    }
}
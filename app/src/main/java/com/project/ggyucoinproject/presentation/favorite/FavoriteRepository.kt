package com.project.ggyucoinproject.presentation.favorite

import androidx.lifecycle.MutableLiveData
import com.project.ggyucoinproject.etc.db.MainDatabase

class FavoriteRepository constructor(private val db: MainDatabase) {

    val favorites = MutableLiveData<List<String>>()

    suspend fun getFavorites() {
        val favoriteMarkets = db.marketDao().getAll().map { it.market }.toList()
        favorites.postValue(favoriteMarkets)
    }
}
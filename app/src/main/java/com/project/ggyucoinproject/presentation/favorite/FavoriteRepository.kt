package com.project.ggyucoinproject.presentation.favorite

import androidx.lifecycle.MutableLiveData
import com.project.ggyucoinproject.etc.db.MainDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteRepository @Inject constructor(private val db: MainDatabase) {

    val favorites = MutableLiveData<List<String>>()

    suspend fun getFavorites() {
        val favoriteMarkets = db.favoriteDao().getAll().map { it.market }.toList()
        favorites.postValue(favoriteMarkets)
    }
}
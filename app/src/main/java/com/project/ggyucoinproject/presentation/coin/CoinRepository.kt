package com.project.ggyucoinproject.presentation.coin

import androidx.lifecycle.MutableLiveData
import com.project.ggyucoinproject.entity.FavoriteEntity
import com.project.ggyucoinproject.etc.db.MainDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

class CoinRepository(private val db: MainDatabase) {

    val favorite = MutableLiveData<Boolean>()

    suspend fun getFavorite(market: String?) {
        coroutineScope {
            val market = db.marketDao().get(market)
            favorite.postValue(market != null)
        }
    }

    suspend fun insertFavorite(favorite: FavoriteEntity) {
        println("insert : ${favorite.market}")
        db.marketDao().insert(favorite)
    }

    suspend fun deleteFavorite(favorite: FavoriteEntity) {
        println("delete : ${favorite.market}")
        db.marketDao().delete(favorite)
    }
}
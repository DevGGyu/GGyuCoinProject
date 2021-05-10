package com.project.ggyucoinproject.presentation.coin

import androidx.lifecycle.MutableLiveData
import com.project.ggyucoinproject.entity.FavoriteEntity
import com.project.ggyucoinproject.etc.db.MainDatabase
import kotlinx.coroutines.coroutineScope

class CoinRepository(private val db: MainDatabase) {

    val favorite = MutableLiveData<Boolean>()

    suspend fun getFavorite(market: String?) {
        coroutineScope {
            val market = db.favoriteDao().get(market)
            favorite.postValue(market != null)
        }
    }

    suspend fun insertFavorite(favorite: FavoriteEntity) {
        println("insert : ${favorite.market}")
        db.favoriteDao().insert(favorite)
    }

    suspend fun deleteFavorite(favorite: FavoriteEntity) {
        println("delete : ${favorite.market}")
        db.favoriteDao().delete(favorite)
    }
}
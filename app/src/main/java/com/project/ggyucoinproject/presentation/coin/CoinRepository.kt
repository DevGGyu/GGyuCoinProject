package com.project.ggyucoinproject.presentation.coin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.project.ggyucoinproject.entity.FavoriteEntity
import com.project.ggyucoinproject.etc.db.MainDatabase
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CoinRepository @Inject constructor(private val db: MainDatabase) {

    val favorite = MutableLiveData<Boolean>()

    suspend fun getFavorite(market: String?) {
        coroutineScope {
            val market = db.favoriteDao().get(market)
            favorite.postValue(market != null)
        }
    }

    suspend fun insertFavorite(favorite: FavoriteEntity) {
        Log.i(TAG, "insert : ${favorite.market}")
        db.favoriteDao().insert(favorite)
    }

    suspend fun deleteFavorite(favorite: FavoriteEntity) {
        Log.i(TAG, "delete : ${favorite.market}")
        db.favoriteDao().delete(favorite)
    }

    companion object {
        private const val TAG = "CoinRepository"
    }
}
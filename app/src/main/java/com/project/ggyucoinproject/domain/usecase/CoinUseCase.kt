package com.project.ggyucoinproject.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.project.ggyucoinproject.data.entity.FavoriteEntity
import com.project.ggyucoinproject.common.MainDatabase
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class CoinUseCase @Inject constructor(private val db: MainDatabase) {

    val favorite = MutableLiveData<Boolean>()

    suspend fun getFavorite(market: String?) {
        coroutineScope {
            val market = db.favoriteDao().get(market)
            favorite.postValue(market != null)
        }
    }

    suspend fun insertFavorite(favorite: FavoriteEntity) {
        db.favoriteDao().insert(favorite)
    }

    suspend fun deleteFavorite(favorite: FavoriteEntity) {
        db.favoriteDao().delete(favorite)
    }
}
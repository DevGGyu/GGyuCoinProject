package com.project.ggyucoinproject.presentation.coin

import android.widget.CompoundButton
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.ggyucoinproject.entity.FavoriteEntity
import kotlinx.coroutines.launch

class CoinViewModel constructor(private val repository: CoinRepository) : ViewModel() {

    val favorite = repository.favorite

    val favoriteChanged = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
        val market = buttonView.tag as String
        val entity = FavoriteEntity(market = market)
        viewModelScope.launch {
            if (isChecked) {
                repository.insertFavorite(entity)
            } else {
                repository.deleteFavorite(entity)
            }
        }
        favorite.postValue(isChecked)
    }

    fun getFavorite(market: String?) {
        viewModelScope.launch {
            repository.getFavorite(market)
        }
    }
}
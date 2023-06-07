package com.project.ggyucoinproject.presentation.coin

import android.widget.CompoundButton
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.ggyucoinproject.domain.usecase.CoinUseCase
import com.project.ggyucoinproject.data.entity.FavoriteEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(private val useCase: CoinUseCase) : ViewModel() {

    val favorite = useCase.favorite

    val favoriteChanged = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
        val market = buttonView.tag as String
        val entity = FavoriteEntity(market = market)
        viewModelScope.launch(Dispatchers.IO) {
            if (isChecked) {
                useCase.insertFavorite(entity)
            } else {
                useCase.deleteFavorite(entity)
            }
        }
        favorite.postValue(isChecked)
    }

    fun getFavorite(market: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getFavorite(market)
        }
    }
}
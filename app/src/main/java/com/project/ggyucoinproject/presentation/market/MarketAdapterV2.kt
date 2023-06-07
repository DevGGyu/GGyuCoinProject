package com.project.ggyucoinproject.presentation.market

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.project.ggyucoinproject.databinding.ItemMarketBinding
import com.project.ggyucoinproject.domain.model.CoinDomain

class MarketAdapterV2(private val listener: SelectCoinListener) :
    ListAdapter<CoinDomain, MarketViewHolder>(MarketDiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MarketViewHolder(
        ItemMarketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MarketViewHolder, position: Int) =
        holder.onBind(getItem(position), listener)

    object MarketDiffUtilCallback : DiffUtil.ItemCallback<CoinDomain>() {
        override fun areItemsTheSame(oldItem: CoinDomain, newItem: CoinDomain): Boolean =
            oldItem.market == newItem.market

        override fun areContentsTheSame(oldItem: CoinDomain, newItem: CoinDomain): Boolean =
            oldItem.tradePrice == newItem.tradePrice
    }
}
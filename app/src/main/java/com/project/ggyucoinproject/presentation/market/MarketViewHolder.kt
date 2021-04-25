package com.project.ggyucoinproject.presentation.market

import androidx.recyclerview.widget.RecyclerView
import com.project.ggyucoinproject.BR
import com.project.ggyucoinproject.databinding.ItemMarketBinding
import com.project.ggyucoinproject.domain.CoinDomain

class MarketViewHolder constructor(private val binding: ItemMarketBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(domain: CoinDomain, listener: MarketAdapter.SelectCoinListener) {
        binding.setVariable(BR.domain, domain)
        binding.setVariable(BR.listener, listener)
        binding.executePendingBindings()
    }
}
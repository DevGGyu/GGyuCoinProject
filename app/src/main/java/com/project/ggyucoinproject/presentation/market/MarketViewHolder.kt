package com.project.ggyucoinproject.presentation.market

import androidx.recyclerview.widget.RecyclerView
import com.project.ggyucoinproject.BR
import com.project.ggyucoinproject.databinding.ItemMarketBinding
import com.project.ggyucoinproject.domain.CoinDomain
import com.project.ggyucoinproject.domain.MarketDomain

class MarketViewHolder constructor(private val binding: ItemMarketBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(domain: CoinDomain) {
        binding.setVariable(BR.domain, domain)
        binding.executePendingBindings()
    }
}
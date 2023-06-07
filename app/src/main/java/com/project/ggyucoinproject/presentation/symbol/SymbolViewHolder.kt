package com.project.ggyucoinproject.presentation.symbol

import androidx.recyclerview.widget.RecyclerView
import com.project.ggyucoinproject.BR
import com.project.ggyucoinproject.databinding.ItemSymbolBinding
import com.project.ggyucoinproject.domain.model.MarketDomain

class SymbolViewHolder constructor(private val binding: ItemSymbolBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(domain: MarketDomain) {
        binding.setVariable(BR.domain, domain)
        binding.executePendingBindings()
    }
}
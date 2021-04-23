package com.project.ggyucoinproject.presentation.market

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.ggyucoinproject.databinding.ItemMarketBinding
import com.project.ggyucoinproject.domain.CoinDomain
import com.project.ggyucoinproject.domain.MarketDomain

class MarketAdapter : RecyclerView.Adapter<MarketViewHolder>() {

    private val mDomains: MutableList<CoinDomain> = mutableListOf()

    fun addDomains(domains: List<CoinDomain>) {
        mDomains.clear()
        mDomains.addAll(domains)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMarketBinding.inflate(inflater, parent, false)
        return MarketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MarketViewHolder, position: Int) {
        val domain = mDomains[position]
        holder.onBind(domain)
    }

    override fun getItemCount(): Int = mDomains.size
}
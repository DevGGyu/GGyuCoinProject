package com.project.ggyucoinproject.presentation.market

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.ggyucoinproject.databinding.ItemMarketBinding
import com.project.ggyucoinproject.domain.CoinDomain

@Deprecated(message = "Deprecated")
class MarketAdapter(private val listener: SelectCoinListener) :
    RecyclerView.Adapter<MarketViewHolder>() {

    private val domainList: MutableList<CoinDomain> = mutableListOf()

    fun addDomains(domains: List<CoinDomain>) {
        domainList.clear()
        domainList.addAll(domains)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMarketBinding.inflate(inflater, parent, false)
        return MarketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MarketViewHolder, position: Int) {
        val domain = domainList[position]
        holder.onBind(domain, listener)
    }

    override fun getItemCount(): Int = domainList.size
}
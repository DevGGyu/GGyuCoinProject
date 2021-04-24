package com.project.ggyucoinproject.presentation.symbol

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.ggyucoinproject.databinding.ItemSymbolBinding
import com.project.ggyucoinproject.domain.MarketDomain

class SymbolAdapter : RecyclerView.Adapter<SymbolViewHolder>() {

    private val mDomains: MutableList<MarketDomain> = mutableListOf()

    fun addDomains(domains: List<MarketDomain>) {
        mDomains.clear()
        mDomains.addAll(domains)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymbolViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSymbolBinding.inflate(inflater, parent, false)
        return SymbolViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SymbolViewHolder, position: Int) {
        val domain = mDomains[position]
        holder.onBind(domain)
    }

    override fun getItemCount(): Int = mDomains.size
}
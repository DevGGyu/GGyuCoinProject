package com.project.ggyucoinproject.presentation.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.project.ggyucoinproject.presentation.favorite.FavoriteFragment
import com.project.ggyucoinproject.presentation.market.MarketFragment
import com.project.ggyucoinproject.presentation.symbol.SymbolFragment

class MainAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    private val arrScreen = arrayOf(MarketFragment(), FavoriteFragment(), SymbolFragment())

    override fun getItemCount(): Int = arrScreen.size

    override fun createFragment(position: Int): Fragment = arrScreen[position]
}
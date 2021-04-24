package com.project.ggyucoinproject.presentation.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.project.ggyucoinproject.databinding.FragmentFavoriteBinding
import com.project.ggyucoinproject.domain.CoinDomain
import com.project.ggyucoinproject.presentation.market.MarketAdapter
import kotlinx.coroutines.launch

class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFavoriteBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DataBindingUtil.bind<FragmentFavoriteBinding>(view) ?: return

        val adapter = MarketAdapter()
        binding.rvFavoriteCoinList.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            val domains = mutableListOf<CoinDomain>()
            repeat((1..20).count()) { num ->
                val domain = CoinDomain("즐겨찾기코인 $num", "57382000.0", "2580000.00000000")
                domains.add(domain)
            }
            adapter.addDomains(domains)
        }
    }
}
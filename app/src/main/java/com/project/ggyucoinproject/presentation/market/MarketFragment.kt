package com.project.ggyucoinproject.presentation.market

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.project.ggyucoinproject.databinding.FragmentMarketBinding
import com.project.ggyucoinproject.domain.CoinDomain
import kotlinx.coroutines.launch

class MarketFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMarketBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DataBindingUtil.bind<FragmentMarketBinding>(view) ?: return

        val adapter = MarketAdapter()
        binding.rvCoinList.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            val domains = mutableListOf<CoinDomain>()
            repeat((1..100).count()) { num ->
                val domain = CoinDomain("비트코인 $num", "57382000.0", "2580000.00000000")
                domains.add(domain)
            }
            adapter.addDomains(domains)
        }
    }
}
package com.project.ggyucoinproject.presentation.symbol

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.project.ggyucoinproject.databinding.FragmentSymbolBinding
import com.project.ggyucoinproject.domain.MarketDomain
import kotlinx.coroutines.launch

class SymbolFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSymbolBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DataBindingUtil.bind<FragmentSymbolBinding>(view) ?: return

        val adapter = SymbolAdapter()
        binding.rvSymbolInfo.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            val domains = mutableListOf<MarketDomain>()
            repeat((1..100).count()) { num ->
                val domain = MarketDomain("KRW-BTC $num", "비트코인", "Bitcoin")
                domains.add(domain)
            }
            adapter.addDomains(domains)
        }
    }
}
package com.project.ggyucoinproject.presentation.market

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.project.ggyucoinproject.databinding.FragmentMarketBinding
import com.project.ggyucoinproject.presentation.owner.OwnerViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MarketFragment : Fragment() {

    private val mVM: OwnerViewModel by sharedViewModel()

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

        mVM.domains.observe(viewLifecycleOwner) { domains ->
            adapter.addDomains(domains)
        }
    }
}
package com.project.ggyucoinproject.presentation.market

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.project.ggyucoinproject.databinding.FragmentMarketBinding
import com.project.ggyucoinproject.presentation.MainFragmentDirections
import com.project.ggyucoinproject.presentation.owner.OwnerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarketFragment : Fragment(), SelectCoinListener {

    private val viewModel: OwnerViewModel by viewModels()

    private lateinit var binding: FragmentMarketBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMarketBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MarketAdapterV2(this)
        binding.rvCoinList.adapter = adapter
        binding.rvCoinList.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        viewModel.domainList.observe(viewLifecycleOwner) { domains ->
            adapter.submitList(domains)
        }
    }

    override fun onCoin(market: String) {
        val action = MainFragmentDirections.actionMainFragmentToCoinFragment(market)
        findNavController().navigate(action)
    }
}
package com.project.ggyucoinproject.presentation.coin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.project.ggyucoinproject.databinding.FragmentCoinBinding
import com.project.ggyucoinproject.presentation.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinFragment : Fragment() {

    private val sharedViewModel: MainViewModel by activityViewModels()
    private val viewModel: CoinViewModel by viewModels()

    private val safeArgs: CoinFragmentArgs by navArgs()

    private lateinit var binding: FragmentCoinBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoinBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.ownerViewModel = sharedViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val market = safeArgs.market

        sharedViewModel.domainList.observe(viewLifecycleOwner) { domains ->
            val coin = domains.find { it.market == market }
            binding.coin = coin
            binding.cbFavorite.tag = coin?.market

            viewModel.getFavorite(market)
        }
    }
}
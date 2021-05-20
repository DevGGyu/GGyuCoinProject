package com.project.ggyucoinproject.presentation.coin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.project.ggyucoinproject.databinding.FragmentCoinBinding
import com.project.ggyucoinproject.presentation.owner.OwnerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinFragment : Fragment() {

    private val mSharedVM: OwnerViewModel by viewModels()
    private val mVM: CoinViewModel by viewModels()

    private val mSafeArgs: CoinFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCoinBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = mVM
        binding.ownerViewModel = mSharedVM
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DataBindingUtil.bind<FragmentCoinBinding>(view) ?: return
        val market = mSafeArgs.market

        mSharedVM.domains.observe(viewLifecycleOwner) { domains ->
            val coin = domains.find { it.market == market }
            binding.coin = coin
            binding.cbFavorite.tag = coin?.market

            mVM.getFavorite(market)
        }
    }
}
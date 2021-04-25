package com.project.ggyucoinproject.presentation.coin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.project.ggyucoinproject.databinding.FragmentCoinBinding
import com.project.ggyucoinproject.presentation.owner.OwnerViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CoinFragment : Fragment() {

    private val mSharedVM: OwnerViewModel by sharedViewModel()
    private val mVM: CoinViewModel by viewModel()

    private val mSafeArgs: CoinFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCoinBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = mVM
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
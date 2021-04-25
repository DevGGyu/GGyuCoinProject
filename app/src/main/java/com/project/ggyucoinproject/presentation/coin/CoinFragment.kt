package com.project.ggyucoinproject.presentation.coin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.project.ggyucoinproject.databinding.FragmentCoinBinding
import com.project.ggyucoinproject.presentation.owner.OwnerViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CoinFragment : Fragment() {

    private val mVM: OwnerViewModel by sharedViewModel()

    private val mSafeArgs: CoinFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCoinBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DataBindingUtil.bind<FragmentCoinBinding>(view) ?: return

        val market = mSafeArgs.market

        mVM.domains.observe(viewLifecycleOwner) { domains ->
            val coin = domains.find { it.market == market }
            binding.coin = coin
        }

        binding.cbFavorite.setOnCheckedChangeListener { buttonView, isChecked ->

        }
    }
}
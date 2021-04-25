package com.project.ggyucoinproject.presentation.coin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.project.ggyucoinproject.databinding.FragmentCoinBinding

class CoinFragment : Fragment() {

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

        binding.cbFavorite.setOnCheckedChangeListener { buttonView, isChecked ->

        }
    }

    override fun onResume() {
        super.onResume()
    }
}
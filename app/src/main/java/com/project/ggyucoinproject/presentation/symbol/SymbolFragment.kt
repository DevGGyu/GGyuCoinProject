package com.project.ggyucoinproject.presentation.symbol

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.project.ggyucoinproject.databinding.FragmentSymbolBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SymbolFragment : Fragment() {

    private val viewModel: SymbolViewModel by viewModels()

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

        viewModel.marketAll.observe(viewLifecycleOwner) { domains ->
            adapter.addDomains(domains)
        }
    }
}
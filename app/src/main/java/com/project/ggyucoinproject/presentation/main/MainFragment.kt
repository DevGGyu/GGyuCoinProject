package com.project.ggyucoinproject.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.project.ggyucoinproject.databinding.FragmentMainBinding
import com.project.ggyucoinproject.presentation.owner.OwnerViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainFragment : Fragment() {

    private val mVM: OwnerViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.vm = mVM
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DataBindingUtil.bind<FragmentMainBinding>(view) ?: return

        binding.viewPager.adapter = MainAdapter(requireActivity())

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "코인목록"
                1 -> tab.text = "즐겨찾기(관심)"
                else -> tab.text = "코인심볼설명"
            }
        }.attach()
    }
}
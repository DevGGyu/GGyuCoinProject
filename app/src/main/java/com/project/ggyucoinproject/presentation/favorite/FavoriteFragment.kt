package com.project.ggyucoinproject.presentation.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.project.ggyucoinproject.databinding.FragmentFavoriteBinding
import com.project.ggyucoinproject.presentation.main.MainFragmentDirections
import com.project.ggyucoinproject.presentation.market.MarketAdapter
import com.project.ggyucoinproject.presentation.market.SelectCoinListener
import com.project.ggyucoinproject.presentation.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteFragment : Fragment(), SelectCoinListener {

    private val sharedViewModel: MainViewModel by activityViewModels()
    private val viewModel: FavoriteViewModel by viewModels()

    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MarketAdapter(this)
        binding.rvFavoriteCoinList.adapter = adapter

        viewModel.favorites.observe(viewLifecycleOwner) { favoriteMarkets ->
            sharedViewModel.domainList.observe(viewLifecycleOwner) { domains ->
                viewLifecycleOwner.lifecycleScope.launch {
                    val favorites = domains.filter {
                        favoriteMarkets.contains(it.market)
                    }.toList()
                    adapter.submitList(favorites)
                }
            }
        }

        viewModel.getFavorites()
    }

    fun reload() = viewModel.getFavorites()

    override fun onCoin(market: String) {
        val action = MainFragmentDirections.actionMainFragmentToCoinFragment(market)
        findNavController().navigate(action)
    }
}
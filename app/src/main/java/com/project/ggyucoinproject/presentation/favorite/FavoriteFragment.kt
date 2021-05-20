package com.project.ggyucoinproject.presentation.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.project.ggyucoinproject.databinding.FragmentFavoriteBinding
import com.project.ggyucoinproject.presentation.main.MainFragmentDirections
import com.project.ggyucoinproject.presentation.market.MarketAdapter
import com.project.ggyucoinproject.presentation.owner.OwnerViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteFragment : Fragment(), MarketAdapter.SelectCoinListener {

    private val mSharedVM: OwnerViewModel by viewModels()
    private val mVM: FavoriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFavoriteBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DataBindingUtil.bind<FragmentFavoriteBinding>(view) ?: return

        val adapter = MarketAdapter(this)
        binding.rvFavoriteCoinList.adapter = adapter

        mVM.favorites.observe(viewLifecycleOwner) { favoriteMarkets ->
            mSharedVM.domains.observe(viewLifecycleOwner) { domains ->
                viewLifecycleOwner.lifecycleScope.launch {
                    val favorites = domains.filter {
                        favoriteMarkets.contains(it.market)
                    }.toList()
                    adapter.addDomains(favorites)
                }
            }
        }

        mVM.getFavorites()
    }

    fun reload() = mVM.getFavorites()

    override fun onCoin(market: String) {
        val action = MainFragmentDirections.actionMainFragmentToCoinFragment(market)
        findNavController().navigate(action)
    }
}
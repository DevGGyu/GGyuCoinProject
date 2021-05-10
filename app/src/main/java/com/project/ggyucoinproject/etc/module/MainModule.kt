package com.project.ggyucoinproject.etc.module

import com.project.ggyucoinproject.presentation.coin.CoinRepository
import com.project.ggyucoinproject.presentation.coin.CoinViewModel
import com.project.ggyucoinproject.presentation.favorite.FavoriteRepository
import com.project.ggyucoinproject.presentation.favorite.FavoriteViewModel
import com.project.ggyucoinproject.presentation.owner.OwnerRepository
import com.project.ggyucoinproject.presentation.owner.OwnerViewModel
import com.project.ggyucoinproject.presentation.splash.SplashRepository
import com.project.ggyucoinproject.presentation.splash.SplashViewModel
import com.project.ggyucoinproject.presentation.symbol.SymbolRepository
import com.project.ggyucoinproject.presentation.symbol.SymbolViewModel
import org.koin.dsl.module

val mainModule = module {

    factory { OwnerViewModel(get()) }
    factory { OwnerRepository(get(), get()) }

    factory { SymbolViewModel(get()) }
    factory { SymbolRepository(get()) }

    factory { CoinViewModel(get()) }
    factory { CoinRepository(get()) }

    factory { FavoriteViewModel(get()) }
    factory { FavoriteRepository(get()) }

    factory { SplashViewModel(get()) }
    factory { SplashRepository(get(), get()) }
}
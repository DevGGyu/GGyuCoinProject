package com.project.ggyucoinproject.etc.module

import com.project.ggyucoinproject.presentation.owner.OwnerRepository
import com.project.ggyucoinproject.presentation.owner.OwnerViewModel
import com.project.ggyucoinproject.presentation.symbol.SymbolRepository
import com.project.ggyucoinproject.presentation.symbol.SymbolViewHolder
import com.project.ggyucoinproject.presentation.symbol.SymbolViewModel
import org.koin.dsl.module

val mainModule = module {

    factory { OwnerViewModel(get()) }
    factory { OwnerRepository(get()) }

    factory { SymbolViewModel(get()) }
    factory { SymbolRepository(get()) }
}
package com.project.ggyucoinproject.etc.module

import com.project.ggyucoinproject.presentation.owner.OwnerRepository
import com.project.ggyucoinproject.presentation.owner.OwnerViewModel
import org.koin.dsl.module

val mainModule = module {

    factory { OwnerViewModel(get()) }
    factory { OwnerRepository(get()) }

}
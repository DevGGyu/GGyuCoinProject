package com.project.ggyucoinproject.etc.module

import com.project.ggyucoinproject.presentation.owner.OwnerRepository
import org.koin.dsl.module

val mainModule = module {

    factory { OwnerRepository(get()) }

}
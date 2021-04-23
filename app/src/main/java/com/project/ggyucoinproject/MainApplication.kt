package com.project.ggyucoinproject

import android.app.Application
import com.project.ggyucoinproject.etc.module.mainModule
import com.project.ggyucoinproject.etc.module.restModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        setUpKoin()
    }

    private fun setUpKoin() {
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(mainModule, restModule))
        }
    }
}
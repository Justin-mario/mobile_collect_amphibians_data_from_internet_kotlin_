package com.example.android.amphibians

import android.app.Application
import com.example.android.amphibians.data.AppContainer
import com.example.android.amphibians.data.DefaultAppContainer

class AmphibiansDetailsApplication : Application(){

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
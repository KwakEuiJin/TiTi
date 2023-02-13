package com.timertiti.titi

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TiTiApplication: Application() {

    override fun onCreate() {
        super.onCreate()

    }

}
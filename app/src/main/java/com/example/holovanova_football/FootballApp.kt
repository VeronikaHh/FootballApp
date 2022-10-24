package com.example.holovanova_football

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FootballApp:  Application() {
    override fun onCreate() {
        super.onCreate()
    }
}


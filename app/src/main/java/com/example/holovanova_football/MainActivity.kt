package com.example.holovanova_football

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.HiltAndroidApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Football)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
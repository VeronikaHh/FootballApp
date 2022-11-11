package com.example.holovanova_football

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.core.di.NetworkModule.provideRetrofit
import com.example.core.di.NetworkModule.providesPlayerService
import com.example.core.di.NetworkModule.providesTeamService
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Football)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigationView.itemIconTintList = null
        bottomNavigationView.setupWithNavController(navController)

        CoroutineScope(Dispatchers.IO).launch {
            val result = providesTeamService(provideRetrofit()).fetchTeamStatistics(2021,33,39)
            val result2 = providesTeamService(provideRetrofit()).fetchTeams(33)
            val result3 = providesPlayerService(provideRetrofit()).fetchPlayers(33)
            Log.d("data", result.toString())
            Log.d("team", result2.toString())
            Log.d("player", result3.toString())
        }
    }
}
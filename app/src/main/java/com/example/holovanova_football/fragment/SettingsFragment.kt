package com.example.holovanova_football.fragment

import android.view.LayoutInflater
import com.example.holovanova_football.databinding.FragmentSettingsBinding

class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentSettingsBinding {
        return FragmentSettingsBinding.inflate(layoutInflater)
    }
}
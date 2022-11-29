package com.example.holovanova_football.fragment

import android.view.LayoutInflater
import com.example.holovanova_football.databinding.FragmentFavoriteBinding

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentFavoriteBinding {
        return FragmentFavoriteBinding.inflate(layoutInflater)
    }
}
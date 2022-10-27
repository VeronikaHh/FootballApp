package com.example.holovanova_football.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.holovanova_football.R
import com.example.holovanova_football.databinding.FragmentFavoriteBinding

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentFavoriteBinding {
        return FragmentFavoriteBinding.inflate(layoutInflater)
    }
}
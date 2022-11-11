package com.example.holovanova_football.fragment

import android.os.Bundle
import android.view.LayoutInflater
import com.example.holovanova_football.databinding.FragmentRatingBinding

class RatingFragment : BaseFragment<FragmentRatingBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentRatingBinding {
        return FragmentRatingBinding.inflate(layoutInflater)
    }
}
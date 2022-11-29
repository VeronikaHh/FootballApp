package com.example.holovanova_football.fragment

import android.view.LayoutInflater
import com.example.holovanova_football.databinding.FragmentRatingBinding

class RatingFragment : BaseFragment<FragmentRatingBinding>() {

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentRatingBinding {
        return FragmentRatingBinding.inflate(layoutInflater)
    }
}
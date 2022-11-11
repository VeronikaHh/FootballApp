package com.example.holovanova_football.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.holovanova_football.databinding.FragmentPlayerBinding


class PlayerFragment : BaseFragment<FragmentPlayerBinding>() {

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentPlayerBinding {
        return FragmentPlayerBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
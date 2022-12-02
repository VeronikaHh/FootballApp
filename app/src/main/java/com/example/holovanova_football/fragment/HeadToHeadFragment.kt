package com.example.holovanova_football.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.holovanova_football.databinding.FragmentHeadToHeadBinding

class HeadToHeadFragment : BaseFragment<FragmentHeadToHeadBinding>() {

    private val navArgs by navArgs<HeadToHeadFragmentArgs>()

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentHeadToHeadBinding {
        return FragmentHeadToHeadBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
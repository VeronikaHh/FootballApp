package com.example.holovanova_football.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.holovanova_football.databinding.FragmentLobbyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LobbyFragment : BaseFragment<FragmentLobbyBinding>() {

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentLobbyBinding {
        return FragmentLobbyBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.testButton.setOnClickListener {
            findNavController().navigate(
                LobbyFragmentDirections.actionToTeamFragment()
            )
        }
    }
}
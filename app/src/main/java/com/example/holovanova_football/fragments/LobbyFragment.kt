package com.example.holovanova_football.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.holovanova_football.R
import com.example.holovanova_football.databinding.FragmentLobbyBinding

class LobbyFragment : BaseFragment<FragmentLobbyBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lobby, container, false)
    }

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentLobbyBinding {
        return FragmentLobbyBinding.inflate(layoutInflater)
    }
}
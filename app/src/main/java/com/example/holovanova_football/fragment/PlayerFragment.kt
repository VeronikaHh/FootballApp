package com.example.holovanova_football.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.holovanova_football.adapter.CareerAdapter
import com.example.holovanova_football.databinding.FragmentPlayerBinding
import com.example.holovanova_football.viewmodel.PlayerViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PlayerFragment : BaseFragment<FragmentPlayerBinding>() {

    private val careerAdapter = CareerAdapter()

    private val playerViewModel: PlayerViewModel by viewModels()

    private val args: PlayerFragmentArgs by navArgs()

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentPlayerBinding {
        return FragmentPlayerBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCollectors()
        initClickListeners()
    }

    private fun initCollectors() {
        binding.carrerRv.apply {
            adapter = careerAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        lifecycleScope.launch {

            val player = args.player
            val team = args.team
            playerViewModel.collectFlow(player, team)
            playerViewModel.data.collect { data ->

                binding.titleToolbar.text = data.player?.name
                binding.playerFirstname.text = data.player?.firstname
                binding.playerLastname.text = data.player?.lastname

                //TODO: replace hardcoded with strings from resource
                binding.nationality.text = "nationality: ${data.player?.nationality}"
                binding.weight.text = "height: ${data.player?.weight}"
                binding.height.text = "weight: ${data.player?.height}"

                binding.position.text = data.statistics?.games?.position.toString()
                binding.rating.text = data.statistics?.games?.rating.toString()

                binding.goals.text = data.statistics?.goals?.total.toString()
                binding.assists.text = data.statistics?.goals?.assists.toString()

                binding.redCard.text = data.statistics?.cards?.red.toString()
                binding.yellowCard.text = data.statistics?.cards?.yellow.toString()

                binding.playerPhoto.load(data.player?.photo)

                data.transfer?.transfers?.let { careerAdapter.setData(it) }
            }
        }
    }

    private fun initClickListeners() {
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
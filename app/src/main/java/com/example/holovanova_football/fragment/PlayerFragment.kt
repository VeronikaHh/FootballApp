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
        showLoadingView()
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

                data.player?.let {
                    binding.titleToolbar.text = it.name
                    binding.playerFirstname.text = it.firstname
                    binding.playerLastname.text = it.lastname

                    //TODO: replace hardcoded with strings from resource
                    binding.nationality.text = "nationality: ${it.nationality}"
                    binding.weight.text = "height: ${it.weight}"
                    binding.height.text = "weight: ${it.height}"

                    binding.playerPhoto.load(it.photo)
                }

                data.statistics?.let {
                    binding.position.text = it.games?.position.toString()
                    binding.rating.text = it.games?.rating.toString()

                    binding.goals.text = it.goals?.total.toString()
                    binding.assists.text = it.goals?.assists.toString()

                    binding.redCard.text = it.cards?.red.toString()
                    binding.yellowCard.text = it.cards?.yellow.toString()
                }

                data.transfer?.transfers?.let { careerAdapter.setData(it) }
                if (playerViewModel.isDataFetched)
                    hideLoadingView()
            }
        }
    }

    private fun initClickListeners() {
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun showLoadingView() {
        binding.progressBar.visibility = View.VISIBLE
        binding.loadingView.visibility = View.VISIBLE
    }

    private fun hideLoadingView() {
        binding.progressBar.visibility = View.GONE
        binding.loadingView.visibility = View.GONE
    }
}
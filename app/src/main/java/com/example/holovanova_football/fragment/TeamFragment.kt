package com.example.holovanova_football.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import coil.decode.SvgDecoder
import coil.load
import com.example.holovanova_football.adapter.PlayerAdapter
import com.example.holovanova_football.adapter.StreakAdapter
import com.example.holovanova_football.databinding.FragmentTeamBinding
import com.example.holovanova_football.viewmodel.TeamViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TeamFragment : BaseFragment<FragmentTeamBinding>() {

    private val viewModel: TeamViewModel by viewModels()

    private val streakAdapter = StreakAdapter()

    private val navArgs by navArgs<TeamFragmentArgs>()

    private var playerAdapter = PlayerAdapter { playerId ->
        viewModel.data.value.team?.team?.id?.let {
            val teamId = it
            openPlayerFragment(playerId, teamId)
        }
    }

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentTeamBinding {
        return FragmentTeamBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoadingView()
        initCollectors()
        initClickListeners()
    }

    private fun initClickListeners() {
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.venueContainer.setOnClickListener {
            val modalBottomSheet = VenueBottomSheet(navArgs.teamId)
            modalBottomSheet.show(parentFragmentManager, VenueBottomSheet.TAG)
        }
    }

    private fun initCollectors() {
        binding.streakRv.apply {
            adapter = streakAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        binding.playerRv.apply {
            adapter = playerAdapter
            layoutManager =
                StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL)
        }

        lifecycleScope.launch {

            viewModel.collectFlow(navArgs.teamId)
            viewModel.data.collect { data ->

                data.teamStatistics?.team?.let {
                    binding.titleToolbar.text = it.name
                    binding.teamName.text = it.name
                    binding.teamLogo.load(it.logo)
                }

                data.teamStatistics?.league?.let {
                    binding.leagueName.text = it.name
                    binding.leagueLogo.load(it.logo)
                    binding.countryName.text = it.country
                    binding.countryFlag.load(it.flag) {
                        decoderFactory { result, options, _ -> SvgDecoder(result.source, options) }
                    }
                }

                data.team?.venue?.let {
                    binding.venueName.text = it.name
                    binding.venuePhoto.load(it.image)
                }

                data.teamStatistics?.form?.let { streakAdapter.setData(it) }

                data.teamStatistics?.goals?.`for`?.let {
                    binding.goalsHome.text =
                        it.total?.home?.toInt().toString()
                    binding.goalsAway.text =
                        it.total?.away?.toInt().toString()

                    binding.goalsAvgHome.text =
                        it.average?.home.toString()
                    binding.goalsAvgAway.text =
                        it.average?.away.toString()
                }

                data.teamStatistics?.clean_sheet?.let {
                    binding.cleanSheetHome.text =
                        it.home?.toInt().toString()
                    binding.cleanSheetAway.text =
                        it.away?.toInt().toString()

                }

                data.teamStatistics?.biggest?.let {
                    binding.winHome.text = it.wins?.home
                    binding.winAway.text = it.wins?.away
                    binding.loseHome.text = it.loses?.home
                    binding.loseAway.text = it.loses?.away

                    it.streak?.let { streak ->
                        binding.win.text = streak.wins.toString()
                        binding.lose.text = streak.loses.toString()
                        binding.draw.text = streak.draws.toString()
                    }
                }

                data.playerSquad?.players?.let { playerAdapter.setData(it) }

                if (viewModel.isDataFetched)
                    hideLoadingView()
            }
        }
    }

    private fun openPlayerFragment(playerId: Int, teamId: Int) {
        findNavController().navigate(
            TeamFragmentDirections.actionToPlayerFragment(playerId, teamId)
        )
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
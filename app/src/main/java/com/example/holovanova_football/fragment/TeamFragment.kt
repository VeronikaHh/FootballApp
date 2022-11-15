package com.example.holovanova_football.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
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

    private val streakAdapter = StreakAdapter()
    private val playerAdapter = PlayerAdapter()

    private val viewModel: TeamViewModel by viewModels()

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentTeamBinding {
        return FragmentTeamBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        binding.back.setOnClickListener {
            findNavController().navigate(
                TeamFragmentDirections.actionToLobbyFragment()
            )
        }

        viewModel.viewModelScope.launch {

            viewModel.data.collect { data ->

                binding.titleToolbar.text = data.teamStatistics?.team?.name
                binding.teamName.text = data.teamStatistics?.team?.name
                binding.teamLogo.load(data.teamStatistics?.team?.logo)
                binding.leagueName.text = data.teamStatistics?.league?.name
                binding.leagueLogo.load(data.teamStatistics?.league?.logo)

                binding.countryName.text = data.teamStatistics?.league?.country
                binding.countryFlag.load(data.teamStatistics?.league?.flag) {
                    decoderFactory { result, options, _ -> SvgDecoder(result.source, options) }
                }

                binding.venueName.text = data.team?.venue?.name
                binding.venuePhoto.load(data.team?.venue?.image)

                binding.streakRv.apply {
                    data.teamStatistics?.form?.let { streakAdapter.setData(it) }
                    adapter = streakAdapter
                    layoutManager =
                        StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
                }

                binding.goalsHome.text =
                    data.teamStatistics?.goals?.`for`?.total?.home?.toInt().toString()
                binding.goalsAway.text =
                    data.teamStatistics?.goals?.`for`?.total?.away?.toInt().toString()

                binding.goalsAvgHome.text =
                    data.teamStatistics?.goals?.`for`?.average?.home.toString()
                binding.goalsAvgAway.text =
                    data.teamStatistics?.goals?.`for`?.average?.away.toString()

                binding.cleanSheetHome.text =
                    data.teamStatistics?.clean_sheet?.home?.toInt().toString()
                binding.cleanSheetAway.text =
                    data.teamStatistics?.clean_sheet?.away?.toInt().toString()

                binding.winHome.text = data.teamStatistics?.biggest?.wins?.home
                binding.winAway.text = data.teamStatistics?.biggest?.wins?.away
                binding.loseHome.text = data.teamStatistics?.biggest?.loses?.home
                binding.loseAway.text = data.teamStatistics?.biggest?.loses?.away

                binding.win.text = data.teamStatistics?.biggest?.streak?.wins.toString()
                binding.lose.text = data.teamStatistics?.biggest?.streak?.loses.toString()
                binding.draw.text = data.teamStatistics?.biggest?.streak?.draws.toString()

                binding.playerRv.apply {
                    data.playerSquad?.players?.let { playerAdapter.setData(it) }
                    adapter = playerAdapter
                    layoutManager =
                        StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL)
                }
            }
        }
    }
}
//TODO: implement Fragment.navigate function
//public fun Fragment.navigate(action: String) {
//    findNavController().navigate(action)
//}
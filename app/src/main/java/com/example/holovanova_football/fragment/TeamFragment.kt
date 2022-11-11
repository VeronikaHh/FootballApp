package com.example.holovanova_football.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.core.domain.model.Player
import com.example.holovanova_football.adapter.PlayerAdapter
import com.example.holovanova_football.adapter.StreakAdapter
import com.example.holovanova_football.databinding.FragmentTeamBinding


class TeamFragment : BaseFragment<FragmentTeamBinding>() {


    val form: String = "LWWWWLWWWWWLWWWWWDWWWWDWWWWWWWLWDWDLWD"

    private val streakAdapter = StreakAdapter()
    private val playerAdapter = PlayerAdapter()

    //test data TODO("replace with actual data")


    var playerList = mutableListOf<Player>(
        Player(
            name = "David de Gea",
            number = 1,
            position = "Goalkeeper",
            photo = "https://media.api-sports.io/football/players/882.png"
        ),
        Player(
            name = "T. Heaton",
            number = 22,
            position = "Goalkeeper",
            photo = "https://media.api-sports.io/football/players/2931.png"
        ),
        Player(
            name = "N. Bishop",
            number = 30,
            position = "Goalkeeper",
            photo = "https://media.api-sports.io/football/players/20319.png"
        ),
        Player(
            name = "M. Dúbravka",
            number = 31,
            position = "Goalkeeper",
            photo = "https://media.api-sports.io/football/players/18886.png"
        )
    )

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentTeamBinding {
        return FragmentTeamBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.back.setOnClickListener{
            findNavController().navigate(
                TeamFragmentDirections.actionTeamFragmentToLobbyFragment()
            )
        }

        binding.playerRv.apply {
            playerAdapter.setData(playerList)
            adapter = playerAdapter
            layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL)
        }

        binding.streakRv.apply {
            streakAdapter.setData(form)
            adapter = streakAdapter
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        }
    }
}

//fun Fragment.navigate(action: String) {
//    findNavController().navigate(action)
//}
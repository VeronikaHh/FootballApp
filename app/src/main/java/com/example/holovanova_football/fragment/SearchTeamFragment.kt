package com.example.holovanova_football.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.holovanova_football.adapter.TeamAdapter
import com.example.holovanova_football.databinding.FragmentSearchTeamBinding
import com.example.holovanova_football.viewmodel.SearchTeamViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchTeamFragment : BaseFragment<FragmentSearchTeamBinding>(),
    SearchView.OnQueryTextListener {

    private val viewModel: SearchTeamViewModel by viewModels()
    private val navArgs by navArgs<SearchTeamFragmentArgs>()

    private val teamAdapter = TeamAdapter { teamId ->
        setFragmentResult(
            navArgs.keyName,
            bundleOf(
                "team" to teamId
            )
        )
        findNavController().navigateUp()
    }

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentSearchTeamBinding {
        return FragmentSearchTeamBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.teamRv.apply {
            adapter = teamAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        binding.searchTeam.setOnQueryTextListener(this)

        //TODO: replace assert call (!!)
        lifecycleScope.launch {
            viewModel.teams.collect { teams ->
                teamAdapter.setData(teams.map { teams -> teams.team!! })
            }
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            search(query)
        }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        return true
    }

    private fun search(query: String) {
        viewModel.collectFlow(query)
    }
}
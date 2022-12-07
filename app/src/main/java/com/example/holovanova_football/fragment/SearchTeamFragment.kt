package com.example.holovanova_football.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.holovanova_football.R
import com.example.holovanova_football.adapter.TeamAdapter
import com.example.holovanova_football.databinding.FragmentSearchTeamBinding
import com.example.holovanova_football.viewmodel.SearchState
import com.example.holovanova_football.viewmodel.SearchTeamViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchTeamFragment : BaseFragment<FragmentSearchTeamBinding>(),
    SearchView.OnQueryTextListener {

    private val viewModel: SearchTeamViewModel by viewModels()
    private val navArgs by navArgs<SearchTeamFragmentArgs>()

    private val teamAdapter = TeamAdapter { teamId ->
        val keyName = navArgs.keyName
        setFragmentResult(
            keyName,
            bundleOf(keyName to teamId)
        )
        findNavController().navigateUp()
    }

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentSearchTeamBinding {
        return FragmentSearchTeamBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCollectors()
        initClickListeners()
    }

    private fun initClickListeners() {
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.searchTeam.setOnQueryTextListener(this)
    }

    private fun initCollectors() {
        binding.teamRv.apply {
            adapter = teamAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.teamsState.collect { teamsState ->
                applyState(
                    containerText = binding.error,
                    progressBar = binding.progressBar,
                    state = teamsState
                )
            }
        }
    }

    private fun applyState(
        containerText: TextView,
        progressBar: ProgressBar,
        state: SearchState
    ) {
        when (state) {
            is SearchState.Selected -> {
                containerText.setText(R.string.empty)
                val teams = state.teams
                teamAdapter.setData(teams.map { it.team!! })
                progressBar.visibility = View.GONE
            }
            is SearchState.Empty -> {
                progressBar.visibility = View.GONE
                containerText.setText(R.string.search_error)
            }
            is SearchState.Loading -> {
                containerText.setText(R.string.empty)
                progressBar.visibility = View.VISIBLE
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
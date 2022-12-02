package com.example.holovanova_football.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.holovanova_football.databinding.FragmentCompareBinding
import com.example.holovanova_football.viewmodel.CompareViewModel
import com.example.holovanova_football.viewmodel.SelectedTeamState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CompareFragment : BaseFragment<FragmentCompareBinding>() {

    companion object {
        private const val FIRST_TEAM_KEY = "firstTeam"
        private const val SECOND_TEAM_KEY = "secondTeam"
    }

    private val viewModel: CompareViewModel by viewModels()

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentCompareBinding {
        return FragmentCompareBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCollectors()
        initFragmentResultsListeners()
        initClickListeners()
    }

    private fun initFragmentResultsListeners() {
        setFragmentResultListener(FIRST_TEAM_KEY) { _, bundle ->
            val firstTeam = bundle.getInt(FIRST_TEAM_KEY)
            viewModel.fetchFirstTeam(firstTeam)

        }

        setFragmentResultListener(SECOND_TEAM_KEY) { _, bundle ->
            val secondTeam = bundle.getInt(SECOND_TEAM_KEY)
            viewModel.fetchSecondTeam(secondTeam)
        }
    }

    private fun initClickListeners() {
        binding.firstContainer.setOnClickListener {
            openSearchFragment(FIRST_TEAM_KEY)
        }

        binding.secondContainer.setOnClickListener {
            openSearchFragment(SECOND_TEAM_KEY)
        }

        binding.compareBtn.setOnClickListener {
            //TODO call openHeadToHeadFragment with args
        }
    }

    private fun initCollectors() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.firstTeamState.collect { state ->
                applySelectedState(
                    containerText = binding.firstContainer,
                    teamLogo = binding.firstTeamLogo,
                    teamName = binding.firstTeamName,
                    state = state
                )
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.secondTeamState.collect { state ->
                applySelectedState(
                    containerText = binding.secondContainer,
                    teamLogo = binding.secondTeamLogo,
                    teamName = binding.secondTeamName,
                    state = state
                )
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.buttonEnabled.collect { isButtonEnabled ->
                binding.compareBtn.isEnabled = isButtonEnabled
            }
        }
    }

    private fun applySelectedState(
        containerText: TextView,
        teamLogo: ImageView,
        teamName: TextView,
        state: SelectedTeamState
    ) {
        when (state) {
            is SelectedTeamState.Selected -> {
                val team = state.team
                //TODO show logo and team name
            }
            is SelectedTeamState.Empty -> {
                //TODO show text

            }
            is SelectedTeamState.Loading -> {
                //TODO show loading
            }

        }
    }

    private fun openSearchFragment(resultKey: String) {
        findNavController().navigate(
            CompareFragmentDirections.actionToSearchTeamFragment(resultKey)
        )
    }

    private fun openHeadToHeadFragment(firstTeamId: Int, secondTeamId: Int) {
        findNavController().navigate(
            CompareFragmentDirections.actionToHeadToHeadFragment(
                firstTeamId = firstTeamId,
                secondTeamId = secondTeamId
            )
        )
    }
}
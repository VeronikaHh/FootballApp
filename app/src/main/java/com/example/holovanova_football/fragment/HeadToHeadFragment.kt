package com.example.holovanova_football.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.holovanova_football.R
import com.example.holovanova_football.adapter.MatchAdapter
import com.example.holovanova_football.databinding.FragmentHeadToHeadBinding
import com.example.holovanova_football.viewmodel.HeadToHeadViewModel
import com.google.android.material.button.MaterialButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HeadToHeadFragment : BaseFragment<FragmentHeadToHeadBinding>() {

    private val viewModel: HeadToHeadViewModel by viewModels()

    private val matchAdapter = MatchAdapter()

    private val navArgs by navArgs<HeadToHeadFragmentArgs>()

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentHeadToHeadBinding {
        return FragmentHeadToHeadBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoadingView()
        initClickListeners()
        initCollectors()
    }

    private fun initCollectors() {
        activeButtonLastTen()

        binding.matchRv.apply {
            adapter = matchAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        lifecycleScope.launch {

            viewModel.collectFlow(navArgs.firstTeamId, navArgs.secondTeamId)

            viewModel.data.collect { data ->
                data.lastTen?.let { list -> matchAdapter.setData(list) }

                data.teams?.let {
                    val toolBarTitle = it.home?.name + " vs " + it.away?.name
                    binding.titleToolbar.text = toolBarTitle

                    binding.homeTeamLogo.load(it.home?.logo)
                    binding.awayTeamLogo.load(it.away?.logo)

                    binding.homeTeamName.text = it.home?.name
                    binding.awayTeamName.text = it.away?.name
                }

                if (viewModel.isDataFetched)
                    hideLoadingView()
            }
        }
    }

    private fun initClickListeners() {

        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnLastTen.setOnClickListener {
            fetchLastTen()
            activeButtonLastTen()
        }

        binding.btnThisSeason.setOnClickListener {
            fetchThisSeason()
            activeButtonThisSeason()
        }

        binding.btnLastSeason.setOnClickListener {
            fetchLastSeason()
            activeButtonLastSeason()
        }

        binding.homeTeamContainer.setOnClickListener {
            viewModel.data.value.teams?.home?.id?.let { openTeamFragment(it) }
        }

        binding.awayTeamContainer.setOnClickListener {
            viewModel.data.value.teams?.away?.id?.let { openTeamFragment(it) }
        }
    }

    private fun getColor(color: Int): Int {
        return ContextCompat.getColor(binding.root.context, color)
    }

    private fun pressedButtonState(
        button: MaterialButton
    ) {
        button.setBackgroundColor(getColor(R.color.blue))
        button.setTextColor(getColor(R.color.white))
    }

    private fun unpressedButtonState(
        button: MaterialButton
    ) {
        button.setBackgroundColor(getColor(R.color.lightBlue))
        button.setTextColor(getColor(R.color.cyanide))
    }

    private fun activeButtonLastTen() {
        pressedButtonState(binding.btnLastTen)
        unpressedButtonState(binding.btnThisSeason)
        unpressedButtonState(binding.btnLastSeason)
    }

    private fun activeButtonLastSeason() {
        pressedButtonState(binding.btnLastSeason)
        unpressedButtonState(binding.btnLastTen)
        unpressedButtonState(binding.btnThisSeason)
    }

    private fun activeButtonThisSeason() {
        pressedButtonState(binding.btnThisSeason)
        unpressedButtonState(binding.btnLastTen)
        unpressedButtonState(binding.btnLastSeason)
    }


    private fun fetchLastTen() {
        lifecycleScope.launch {
            viewModel.data.collect { data ->
                data.lastTen?.let { matchAdapter.setData(it) }
            }
        }
    }

    private fun fetchThisSeason() {
        lifecycleScope.launch {
            viewModel.data.collect { data ->
                data.thisSeason?.let { matchAdapter.setData(it) }
            }
        }
    }

    private fun fetchLastSeason() {
        lifecycleScope.launch {
            viewModel.data.collect { data ->
                data.lastSeason?.let { matchAdapter.setData(it) }
            }
        }
    }

    private fun openTeamFragment(teamId: Int) {
        findNavController().navigate(
            HeadToHeadFragmentDirections.actionToTeam(teamId)
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
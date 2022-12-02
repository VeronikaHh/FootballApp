package com.example.holovanova_football.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.holovanova_football.R
import com.example.holovanova_football.databinding.FragmentCompareBinding
import com.example.holovanova_football.viewmodel.CompareViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CompareFragment : BaseFragment<FragmentCompareBinding>() {

    companion object {
        private const val FIRST_TEAM_KEY = "firstTeam"
        private const val SECOND_TEAM_KEY = "secondTeam"
    }

    //private val args: RatingFragmentArgs by navArgs()
    private var firstTeamArgs: Int? = null
    private var secondTeamArgs: Int? = null

    private val viewModel: CompareViewModel by viewModels()

    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentCompareBinding {
        return FragmentCompareBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val blueColor = ContextCompat.getColor(binding.root.context, R.color.blue)
        val grayColor = ContextCompat.getColor(binding.root.context, R.color.gray)
        binding.compareBtn.isEnabled = false
        binding.compareBtn.setBackgroundColor(grayColor)

        setFragmentResultListener(FIRST_TEAM_KEY) { key, bundle ->
            val firstTeam = bundle.getInt("team")
            lifecycleScope.launch {
                viewModel.collectFlow(firstTeam)
                viewModel.data.collect { data ->
                    binding.firstContainer.text = ""
                    binding.firstTeamLogo.load(data.team?.logo)
                    binding.firstTeamName.text = data.team?.name
                }
            }
            firstTeamArgs = firstTeam
        }

        setFragmentResultListener(SECOND_TEAM_KEY) { key, bundle ->
            val secondTeam = bundle.getInt("team")
            lifecycleScope.launch {
                viewModel.collectFlow(secondTeam)
                viewModel.data.collect { data ->
                    binding.secondContainer.text = ""
                    binding.secondTeamLogo.load(data.team?.logo)
                    binding.secondTeamName.text = data.team?.name
                }
            }
            secondTeamArgs = secondTeam
        }

        if (firstTeamArgs != null && secondTeamArgs != null) {
            binding.compareBtn.isEnabled = true
            binding.compareBtn.setBackgroundColor(blueColor)
        }

        binding.firstContainer.setOnClickListener {
            findNavController().navigate(
                CompareFragmentDirections.actionToSearchTeamFragment(FIRST_TEAM_KEY)
            )
        }

        binding.secondContainer.setOnClickListener {
            findNavController().navigate(
                CompareFragmentDirections.actionToSearchTeamFragment(SECOND_TEAM_KEY)
            )
        }

        //TODO: replace assert call (!!)
        binding.compareBtn.setOnClickListener {
            if (firstTeamArgs != null && secondTeamArgs != null) {
                findNavController().navigate(
                    CompareFragmentDirections.actionToHeadToHeadFragment(
                        firstTeamArgs!!,
                        secondTeamArgs!!
                    )
                )
            }
        }
    }
}
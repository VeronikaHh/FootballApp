package com.example.holovanova_football.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.holovanova_football.databinding.LayoutVenueBinding
import com.example.holovanova_football.viewmodel.TeamViewModel
import com.example.holovanova_football.viewmodel.VenueViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class VenueBottomSheet(private val teamId: Int) : BottomSheetDialogFragment() {

    private val viewModel: VenueViewModel by viewModels()

    private var _binding: LayoutVenueBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LayoutVenueBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCollectors()
    }

    private fun initCollectors() {
        lifecycleScope.launch {
            viewModel.collectFlow(teamId)
            viewModel.team.collect { team ->
                team.venue?.let {
                    binding.venueName.text = it.name
                    binding.venuePhoto.load(it.image)
                    binding.city.text = it.city
                    binding.address.text = it.address
                    binding.surface.text = it.surface
                    binding.capacity.text = it.capacity.toString()
                }
            }
        }
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }
}

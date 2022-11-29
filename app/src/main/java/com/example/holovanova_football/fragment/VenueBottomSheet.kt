package com.example.holovanova_football.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import coil.load
import com.example.holovanova_football.databinding.LayoutVenueBinding
import com.example.holovanova_football.viewmodel.TeamViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class VenueBottomSheet : BottomSheetDialogFragment() {


    private val viewModel: TeamViewModel by viewModels()

    private var _binding: LayoutVenueBinding? = null

    protected val binding get() = _binding!!

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

        lifecycleScope.launch {

            viewModel.data.collect { data ->
                binding.venueName.text = data.team?.venue?.name
                binding.venuePhoto.load(data.team?.venue?.image)
                binding.city.text = data.team?.venue?.city
                binding.address.text = data.team?.venue?.address
                binding.surface.text = data.team?.venue?.surface
                binding.capacity.text = data.team?.venue?.capacity.toString()
            }
        }
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }
}

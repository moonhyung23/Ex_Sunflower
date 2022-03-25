package com.example.a223010_sunflower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.a223010_sunflower.adapters.PlantAdapter
import com.example.a223010_sunflower.databinding.FragmentPlantListBinding
import com.example.a223010_sunflower.viewmodels.PlantListViewModel
import dagger.hilt.android.AndroidEntryPoint

/* 전체 식물 모음 */
@AndroidEntryPoint
class PlantListFragment : Fragment() {
    private val viewModel: PlantListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentPlantListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        //리사이클러뷰 어댑터 세팅
        val adapter = PlantAdapter()
        binding.plantList.adapter = adapter
        subscribeUi(adapter)
        return binding.root


    }

    private fun subscribeUi(adapter: PlantAdapter) {
        viewModel
    }
}
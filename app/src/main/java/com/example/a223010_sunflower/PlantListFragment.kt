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
        binding.plantList.setHasFixedSize(true)

        subscribeUi(adapter)
        return binding.root


        /*  gardenViewModel.live_MygardenPlant.observe(viewLifecycleOwner, Observer { result ->
              //result의 값이 있을 때는 true
              binding.hasPlantings = !result.isNullOrEmpty()
              //리스트가 변경되었음을 어댑터에게 알려줌으로써 UI 갱신
              adapter.submitList(result)
          })*/


    }

    private fun subscribeUi(adapter: PlantAdapter) {
        viewModel
    }
}
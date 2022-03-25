package com.example.a223010_sunflower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.example.a223010_sunflower.adapters.GardenPlantingAdapter
import com.example.a223010_sunflower.adapters.PLANT_LIST_PAGE_INDEX
import com.example.a223010_sunflower.databinding.FragmentGardenBinding
import com.example.a223010_sunflower.viewmodels.GardenPlantingListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GardenFragment : Fragment() {
    /* 내가 추가한 식물 프래그먼트  */
    private lateinit var binding: FragmentGardenBinding
    private val gardenViewModel: GardenPlantingListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentGardenBinding.inflate(inflater, container, false)
        val adapter = GardenPlantingAdapter()
        binding.gardenList.adapter = adapter


        //식물 추가 버튼
        binding.addPlant.setOnClickListener {
            navigateToPlantListPage()
        }

        //리사이클러뷰 Ui 갱신
        subscribeUi(adapter, binding)
        return binding.root
    }

    //리사이클러뷰에 UI 갱신
    private fun subscribeUi(adapter: GardenPlantingAdapter, binding: FragmentGardenBinding) {
        //내가 갖고있는 식물 리스트의 갱신을 감지
        gardenViewModel.live_MygardenPlant.observe(viewLifecycleOwner, Observer { result ->
            //result의 값이 있을 때는 true
            binding.hasPlantings = !result.isNullOrEmpty()
            //리스트가 변경되었음을 어댑터에게 알려줌으로써 UI 갱신
            adapter.submitList(result)
        })

    }

    //뷰페이저의 페이지의 개수 반환
    private fun navigateToPlantListPage() {
        requireActivity().findViewById<ViewPager2>(R.id.view_pager).currentItem =
            PLANT_LIST_PAGE_INDEX
    }
}
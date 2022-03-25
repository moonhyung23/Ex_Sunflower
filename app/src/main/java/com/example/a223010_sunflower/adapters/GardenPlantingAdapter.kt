package com.example.a223010_sunflower.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a223010_sunflower.HomeViewPagerFragmentDirections
import com.example.a223010_sunflower.R
import com.example.a223010_sunflower.data.PlantAndGardenPlantings
import com.example.a223010_sunflower.databinding.ListItemGardenPlantingBinding
import com.example.a223010_sunflower.viewmodels.PlantAndGardenPlantingsViewModel

class GardenPlantingAdapter :
    ListAdapter<PlantAndGardenPlantings, GardenPlantingAdapter.ViewHolder>(
        GardenPlantDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {

        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_garden_planting,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GardenPlantingAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ListItemGardenPlantingBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            //식물 정보 아이템뷰 클리 이벤트
            binding.setClickListener { view ->
                binding.viewModel?.plantId?.let { plantId ->
                    //해당하는 식물 아이템뷰의 id를 입력
                    navigateToPlant(plantId, view)
                }
            }
        }

        private fun navigateToPlant(plantId: String, view: View) {
            //화면 전환시 식물 아이템뷰의 id를 입력해서 전달
            val direction = HomeViewPagerFragmentDirections
                .actionViewPagerFragmentToPlantDetailFragment(plantId)
            view.findNavController().navigate(direction)
        }

        fun bind(plantings: PlantAndGardenPlantings) {
            with(binding) {
                viewModel = PlantAndGardenPlantingsViewModel(plantings)
                executePendingBindings()
            }
        }

    }

}

//DiffUtill을 사용하기 위한 기본 세팅
private class GardenPlantDiffCallback : DiffUtil.ItemCallback<PlantAndGardenPlantings>() {
    override fun areItemsTheSame(
        oldItem: PlantAndGardenPlantings,
        newItem: PlantAndGardenPlantings,
    ): Boolean {
        return oldItem.plant.plantId == newItem.plant.plantId
    }

    override fun areContentsTheSame(
        oldItem: PlantAndGardenPlantings,
        newItem: PlantAndGardenPlantings,
    ): Boolean {
        return oldItem.plant == newItem.plant
    }
}
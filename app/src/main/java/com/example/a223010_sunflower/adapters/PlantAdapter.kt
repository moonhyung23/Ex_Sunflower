package com.example.a223010_sunflower.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a223010_sunflower.HomeViewPagerFragmentDirections
import com.example.a223010_sunflower.data.Plant
import com.example.a223010_sunflower.databinding.ListItemPlantBinding

class PlantAdapter : ListAdapter<Plant, RecyclerView.ViewHolder>(PlantDiffCallback()) {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //리사이클러뷰에 필요한 아이템뷰를 생성
        return PlantViewHolder(
            //DataBinding을 사용하기 때문에 ItemView.xml 파일 입력 안해도 가능
            ListItemPlantBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val plant = getItem(position)
        (holder as PlantViewHolder).bind(plant)
    }

    //뷰홀더
    class PlantViewHolder(
        private val binding: ListItemPlantBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            //클릭한 식물 정보로 이동
            binding.setClickListener { view ->
                binding.plant?.let { plant ->
                    navigateToPlant(plant, view)
                }

            }
        }

        private fun navigateToPlant(
            plant: Plant,
            view: View,
        ) {
            //방향 뷰페이저에서 -> 식물 상세정보 프래그먼트
            //전달하는 데이터 plant.id(식물의 인덱스 번호)
            val direction =
                HomeViewPagerFragmentDirections.actionViewPagerFragmentToPlantDetailFragment(
                    plant.plantId
                )

            view.findNavController().navigate(direction)
        }

        fun bind(item: Plant) {
            binding.apply {
                //DataBinding으로 리사이클러뷰의 아이템뷰 데이터 갱신을
                //위한 객체 초기화
                plant = item
                executePendingBindings()
            }
        }
    }
}

/*리사이클러뷰의 성능향상을 위한 DiffCallCallBack */
private class PlantDiffCallback : DiffUtil.ItemCallback<Plant>() {
    override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem.plantId == newItem.plantId
    }

    override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem == newItem
    }


}


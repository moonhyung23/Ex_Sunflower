package com.example.a223010_sunflower.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.a223010_sunflower.data.GardenPlantingRepository
import com.example.a223010_sunflower.data.PlantAndGardenPlantings
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
//@inject constructor란 생성자 삽입 방법으로 클래스 인스턴스를 제공하다고 Hilt에게 알려줌

//@HiltViewModel에서 @Inject 어노테이션이 붙은 생성자는
//생성자 파라미터가 Hilt에 의해 주입받을 거라고 정의내림
class GardenPlantingListViewModel @Inject internal constructor(
    gardenPlantingRepository: GardenPlantingRepository,
) : ViewModel() {
    //라이브데이터가 관찰하는 데이터 -> 내가 추가한 식물 리스트
    val live_MygardenPlant: LiveData<List<PlantAndGardenPlantings>> =
        gardenPlantingRepository.getPlantedGardensFlow().asLiveData()
}
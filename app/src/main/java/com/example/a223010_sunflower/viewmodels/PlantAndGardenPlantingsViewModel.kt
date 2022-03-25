package com.example.a223010_sunflower.viewmodels

import com.example.a223010_sunflower.data.PlantAndGardenPlantings
import java.text.SimpleDateFormat
import java.util.*

//식물관련 정보 데이터를 처리하는 ViewModel
class PlantAndGardenPlantingsViewModel(plantings: PlantAndGardenPlantings) {
    private val plant = checkNotNull(plantings.plant)
    private val gardenPlanting = plantings.List_gardenPlantings[0]

    /* 리사이클러뷰에서 사용할 데이터 정보 */

    //물주는 시기
    val wateringInterval
        get() = plant.imageUrl

    //식물 사진 url
    val imageUrl
        get() = plant.imageUrl

    //식물 이름
    val plantName
        get() = plant.name

    //식물 id
    val plantId
        get() = plant.plantId
//    val plantDateString: String = dateFormat.format

//    val waterDateString: String = dateFormat.format(gardenPlanting.)

    companion object {
        private val dateFormat = SimpleDateFormat("MMM d, yyyy", Locale.US)
    }


}
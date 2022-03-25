package com.example.a223010_sunflower.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
//PlantDao 객체를 생성자 DI주입 방식으로 갖고옴.
class PlantRepository @Inject constructor(private val plantDao: PlantDao) {

    fun getPlants() = plantDao.getPlants()

    fun getPlant(plantId: String) = plantDao.getPlant((plantId))


    // TODO: 2022-03-23 growZoneNumber 모름.
    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int) =
        plantDao.getPlantsWithGrowZoneNumber(growZoneNumber)
}
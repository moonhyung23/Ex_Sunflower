package com.example.a223010_sunflower.data

import androidx.room.Embedded
import androidx.room.Relation

data class PlantAndGardenPlantings(
    //항목의 내용이 Object일 때 지정해줌.
    @Embedded
    val plant: Plant,
    @Relation(parentColumn = "id", entityColumn = "plant_id")
    val List_gardenPlantings: List<GardenPlanting> = emptyList(),
)
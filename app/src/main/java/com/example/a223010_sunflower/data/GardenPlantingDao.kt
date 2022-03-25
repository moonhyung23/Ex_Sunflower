package com.example.a223010_sunflower.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

//Room에 있는 식물 정보에 접근할 수 있는
//메서드 모음
@Dao
interface GardenPlantingDao {
    //식물 정보 전체 조회
    @Query("SELECT * FROM garden_plantings")
    fun getGardenPlantings(): Flow<List<GardenPlanting>>


    //Room에 있는 식물정보 조회??
    @Transaction
    // TODO: 2022-03-23 쿼리문 뜻 공부
    @Query("SELECT * FROM plants WHERE id IN (SELECT DISTINCT(plant_id) FROM garden_plantings)")
    fun getPlantedGardensFlow(): Flow<List<PlantAndGardenPlantings>>

}
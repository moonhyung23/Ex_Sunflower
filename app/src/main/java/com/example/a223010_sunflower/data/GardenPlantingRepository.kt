package com.example.a223010_sunflower.data

import javax.inject.Inject
import javax.inject.Singleton


//1.Repository를 통해 RoomDB 저장소에 접근해서
//데이터를 갖고온다.

//2.저장소이기 때문에 Singleton으로 어디서든 객체를
//갖고올 수 있게 한다.

//3.@Inject 생성자 주입방식으로 Repository를 주입받음.
@Singleton
class GardenPlantingRepository @Inject constructor(
    //Room에 있는 식물정보에 접근할 수 있는 쿼리문이 저장된 객체
    /* 외부 객체인 gardenPlantingDao를 DI에서 주입을 받음.
    * */
    private val gardenPlantingDao: GardenPlantingDao,
) {

    //전체 내가 추가한 식물 RoomDB에서 받아오기
    fun getPlantedGardensFlow() = gardenPlantingDao.getPlantedGardensFlow()
}
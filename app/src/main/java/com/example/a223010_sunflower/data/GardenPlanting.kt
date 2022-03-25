package com.example.a223010_sunflower.data

import androidx.room.*
import java.util.*

/*  Room에서 사용할 테이블  */

//테이블 정보 정의
@Entity(
    tableName = "garden_plantings",
    //테이블에서 참조할 외래키
    foreignKeys = [
        ForeignKey(entity = Plant::class, parentColumns = ["id"], childColumns = ["plant_id"]
        )],
    indices = [Index("plant_id")]
)

//테이블에서 사용할 컬럼 정의
data class GardenPlanting(
    @ColumnInfo(name = "plant_id") val plantId: String,
    @ColumnInfo(name = "plant_date") val plantDate: Calendar = Calendar.getInstance(),
    @ColumnInfo(name = "last_watering_date")
    val lastWateringDate: Calendar = Calendar.getInstance(),
) {
    //기본 키 index
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var gardenPlantingId: Long = 0
}
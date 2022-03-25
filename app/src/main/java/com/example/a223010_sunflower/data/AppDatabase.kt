package com.example.a223010_sunflower.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.a223010_sunflower.utilities.DATABASE_NAME
import com.example.a223010_sunflower.utilities.PLANT_DATA_FILENAME
import com.example.a223010_sunflower.workers.SeedDatabaseWorker
import com.example.a223010_sunflower.workers.SeedDatabaseWorker.Companion.KEY_FILENAME


/* Room Database 객체를 얻기위한 추상 클래스*/

//Database에서 사용할 테이블 정의
@Database(entities = [GardenPlanting::class, Plant::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    //Room의 접근하기위한 객체
    abstract fun gardenPlantingDao(): GardenPlantingDao
    abstract fun plantDao(): PlantDao

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null


        //싱글턴 패턴을 사용해서 Room DB 객체를 얻어온다.
        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }


        // TODO: 2022-03-23 WorkManager를 사용해서 RoomDb 사용하는 방법 공부
        //WorkManager를 이용해서 RoomDataBase 객체를 생성
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            //workManager를 통해 RoomDB에 식물정보를 추가한 후 RoomDB 객체를 반환
                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>()
                                .setInputData(workDataOf(KEY_FILENAME to PLANT_DATA_FILENAME))
                                .build()
                            //WorkManager에 작업 요청
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    }
                ).build()
        }
    }

}

package com.example.a223010_sunflower.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.a223010_sunflower.data.AppDatabase
import com.example.a223010_sunflower.data.Plant
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/* 어플이 시작할 때 식물 정보 Json객체를
*  RoomDatabase에 입력하기 위해 Worker에 작업을 할당한다.
*  CoroutineWorker를 사용
*
* */

class SeedDatabaseWorker(
    context: Context,
    workParams: WorkerParameters,
) : CoroutineWorker(context, workParams) {
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val filename = inputData.getString(KEY_FILENAME)
            if (filename != null) {
                //assets에 있는 식물정보 데이터(JSON)를 갖고오기
                applicationContext.assets.open(filename).use { inputStream ->
                    JsonReader(inputStream.reader()).use { jsonReader ->
                        //Json 파싱할 식물정보
                        val plantType = object : TypeToken<List<Plant>>() {}.type
                        //JSon으로 파싱한 식물정보를 리스트에 담는다.
                        val plantList: List<Plant> = Gson().fromJson(jsonReader, plantType)
                        //RoomDB 객체 생성
                        val database = AppDatabase.getInstance(applicationContext)
                        //Room DB에 식물정보를 넣는다.

                        // TODO: 2022-03-23 TODO: 2022-03-23 plantDao().insertAll 작성
                        database.plantDao().insertAll(plantList)
                        Result.success()
                    }
                }
            } else {
                Log.e(TAG, "Error seeding database - no valid filename")
                Result.failure()
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error seeding database", e)
            Result.failure()
        }
    }


    companion object {
        private const val TAG = "SeedDatabaseWorker"
        const val KEY_FILENAME = "PLANT_DATA_FILENAME"
    }


}
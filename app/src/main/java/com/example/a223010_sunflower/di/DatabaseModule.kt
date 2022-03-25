package com.example.a223010_sunflower.di

import android.content.Context
import com.example.a223010_sunflower.data.AppDatabase
import com.example.a223010_sunflower.data.GardenPlantingDao
import com.example.a223010_sunflower.data.PlantDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Hilt Module을 사용하기 위해 필요한 어노테이션
@InstallIn(SingletonComponent::class)
@Module
// TODO: 2022-03-23 DatabaseModule DI 복습
// provides, Singleton 사용하는 경우 공부
class DatabaseModule {
    // RoomDB 객체를 제공받음
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    //Room의 식물 정보에 접근할 수 있는 객체 제공
    @Provides
    fun providePlantDao(appDatabase: AppDatabase): PlantDao {
        return appDatabase.plantDao()
    }


    //Room의 식물 정보에 접근할 수 있는 객체 제공
    @Provides
    fun provideGardenPlantingDao(appDatabase: AppDatabase): GardenPlantingDao {
        return appDatabase.gardenPlantingDao()
    }


}
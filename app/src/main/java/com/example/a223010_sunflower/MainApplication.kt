package com.example.a223010_sunflower

import android.app.Application
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp

//Hilt 의존성 라이브러리 사용 선언
//Hilt를 사용하기 위해서는 반드시 Application클래스를 만들어야 함.
@HiltAndroidApp
class MainApplication : Application(), Configuration.Provider {
    // TODO: 2022-03-23 configuration 왜 초기화 하는지 공부 
    override fun getWorkManagerConfiguration() =
        Configuration.Builder()
            .setMinimumLoggingLevel(if (BuildConfig.DEBUG) android.util.Log.DEBUG else android.util.Log.ERROR)
            .build()
}

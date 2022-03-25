package com.example.a223010_sunflower.data

import androidx.room.TypeConverter
import java.util.*

// TODO: 2022-03-23 TypeConverter 왜 쓰는지 공부
class Converters {
    @TypeConverter
    fun calendarToDatestamp(calendar: Calendar): Long = calendar.timeInMillis

    @TypeConverter
    fun datestampToCalendar(value: Long): Calendar =
        Calendar.getInstance().apply { timeInMillis = value }
}
package com.example.android_practice_7.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.android_practice_7.data.remote.model.Result

@Database(entities = [Result::class], version = 1)
@TypeConverters(Converters::class)
abstract class CoinDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinDao
}
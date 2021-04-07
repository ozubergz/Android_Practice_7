package com.example.android_practice_7.data.local

import androidx.room.TypeConverter
import com.example.android_practice_7.data.remote.model.Coin
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class Converters {

    @TypeConverter
    fun coinToString(coins: List<Coin>) : String {
        val type = Types.newParameterizedType(List::class.java, Coin::class.java)
        val adapter = Moshi.Builder().build().adapter<List<Coin>>(type)
        return adapter.toJson(coins)
    }

    @TypeConverter
    fun stringToCoin(json: String) : List<Coin>? {
        val type = Types.newParameterizedType(List::class.java, Coin::class.java)
        val adapter = Moshi.Builder().build().adapter<List<Coin>>(type)
        return adapter.fromJson(json)
    }
}
package com.example.android_practice_7.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android_practice_7.data.remote.model.Result
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun cache(result: Result)

    @Query("SELECT * FROM result")
    fun load() : Flow<Result>
}
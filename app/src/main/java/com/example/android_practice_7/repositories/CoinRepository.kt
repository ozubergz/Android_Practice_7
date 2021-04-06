package com.example.android_practice_7.repositories

import com.example.android_practice_7.data.remote.RetrofitInstance
import com.example.android_practice_7.data.remote.model.Result
import retrofit2.Call

object CoinRepository {

    private val service = RetrofitInstance.service

    fun fetchCoinsApi() : Call<Result> {
        return service.fetchCoinsApi()
    }

}
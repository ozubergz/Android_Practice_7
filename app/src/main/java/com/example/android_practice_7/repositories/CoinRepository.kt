package com.example.android_practice_7.repositories

import com.example.android_practice_7.data.remote.RetrofitInstance
import com.example.android_practice_7.data.remote.model.Result
import retrofit2.Call
import retrofit2.Response

object CoinRepository {

    private val service = RetrofitInstance.service

    suspend fun fetchCoinsApi() : Response<Result> {
        return service.fetchCoinsApi()
    }

}
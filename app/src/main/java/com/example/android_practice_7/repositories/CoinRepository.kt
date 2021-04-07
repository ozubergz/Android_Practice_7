package com.example.android_practice_7.repositories

import com.example.android_practice_7.data.remote.CoinService
import com.example.android_practice_7.data.remote.model.Result
import retrofit2.Response
import javax.inject.Inject

class CoinRepository @Inject constructor(
    private val coinService: CoinService
) {

    suspend fun fetchCoinsApi() : Response<Result> {
        return coinService.fetchCoinsApi()
    }

}
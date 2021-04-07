package com.example.android_practice_7.data.remote

import com.example.android_practice_7.data.remote.model.Result
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface CoinService {

    @GET("tickers")
    suspend fun fetchCoinsApi() : Response<Result>
}
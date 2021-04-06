package com.example.android_practice_7.data.remote

import com.example.android_practice_7.data.remote.model.Result
import retrofit2.Call
import retrofit2.http.GET

interface CoinService {

    @GET("tickers")
    fun fetchCoinsApi() : Call<Result>
}
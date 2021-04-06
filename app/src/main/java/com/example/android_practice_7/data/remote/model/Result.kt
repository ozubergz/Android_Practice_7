package com.example.android_practice_7.data.remote.model


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    val data: List<Coin>
)
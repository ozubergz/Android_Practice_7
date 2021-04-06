package com.example.android_practice_7.data.remote.model


import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Result(
    val data: List<Coin>
) : Parcelable
package com.example.android_practice_7.data.remote.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Coin(
    val csupply: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "market_cap_usd")
    val marketCapUsd: String,
    val msupply: String?,
    @Json(name = "name")
    val name: String,
    val nameid: String,
    @Json(name = "percent_change_1h")
    val percentChange1h: String,
    @Json(name = "percent_change_24h")
    val percentChange24h: String,
    @Json(name = "percent_change_7d")
    val percentChange7d: String,
    @Json(name = "price_btc")
    val priceBtc: String,
    @Json(name = "price_usd")
    val priceUsd: String,
    val rank: Int,
    val symbol: String,
    val tsupply: String?,
    val volume24: Double,
    val volume24a: Double
) : Parcelable
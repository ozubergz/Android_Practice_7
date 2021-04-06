package com.example.android_practice_7.adapters

import com.example.android_practice_7.data.remote.model.Coin

interface ClickListener {
    fun itemClicked(coin: Coin)
}
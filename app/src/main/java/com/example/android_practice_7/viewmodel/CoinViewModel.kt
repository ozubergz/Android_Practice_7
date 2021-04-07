package com.example.android_practice_7.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_practice_7.data.remote.model.Coin
import com.example.android_practice_7.data.remote.model.Result
import com.example.android_practice_7.repositories.CoinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinViewModel : ViewModel() {

    private var coinRepository = CoinRepository

    private val _data = MutableLiveData<Result>()
    val data : LiveData<Result> get() = _data

    fun fetchCoinsApi() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = coinRepository.fetchCoinsApi()
            _data.postValue(response.body())
        }
    }
}
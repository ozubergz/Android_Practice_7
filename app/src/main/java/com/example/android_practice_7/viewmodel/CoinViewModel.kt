package com.example.android_practice_7.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_practice_7.data.remote.model.Result
import com.example.android_practice_7.repositories.CoinRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinViewModel : ViewModel() {

    private var coinRepository = CoinRepository
    private val _data = MutableLiveData<Result>()
    val data : LiveData<Result>
        get() = _data

    fun fetchCoinsApi() {
        val call = coinRepository.fetchCoinsApi()
        call.enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                _data.postValue(response.body())
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                Log.d("Call Failure", "onFailure: ${t.message}")
            }
        })
    }
}
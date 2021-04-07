package com.example.android_practice_7.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_practice_7.data.remote.model.Result
import com.example.android_practice_7.repositories.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private var coinRepository: CoinRepository
) : ViewModel() {

    private val _data = MutableLiveData<Result>()
    val data : LiveData<Result> get() = _data

    fun fetchCoinsApi() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = coinRepository.fetchCoinsApi()
            _data.postValue(response.body())
        }
    }
}
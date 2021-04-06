package com.example.android_practice_7.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_practice_7.R
import com.example.android_practice_7.viewmodel.CoinViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel : CoinViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.fetchCoinsApi()

    }
}
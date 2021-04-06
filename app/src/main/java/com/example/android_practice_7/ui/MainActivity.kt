package com.example.android_practice_7.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice_7.R
import com.example.android_practice_7.adapters.CoinAdapter
import com.example.android_practice_7.databinding.ActivityMainBinding
import com.example.android_practice_7.viewmodel.CoinViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel : CoinViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.fetchCoinsApi()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.apply {
            viewModel.data.observe(this@MainActivity, {
                rvCoins.apply {
                    adapter = CoinAdapter(it.data)
                    layoutManager = LinearLayoutManager(this@MainActivity)
                }
            })
        }
    }
}
package com.example.android_practice_7.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.android_practice_7.R
import com.example.android_practice_7.databinding.FragmentCoinItemBinding
import com.example.android_practice_7.viewmodel.CoinViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinItemFragment : Fragment() {

    private lateinit var binding: FragmentCoinItemBinding
    private val args : CoinItemFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCoinItemBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coin = args.coin

        binding.apply {
            tvName.text = coin.name
        }
    }
}
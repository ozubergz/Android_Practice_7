package com.example.android_practice_7.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_practice_7.R
import com.example.android_practice_7.adapters.ClickListener
import com.example.android_practice_7.adapters.CoinAdapter
import com.example.android_practice_7.data.remote.model.Coin
import com.example.android_practice_7.databinding.FragmentCoinsBinding
import com.example.android_practice_7.viewmodel.CoinViewModel


class CoinsFragment : Fragment(), ClickListener {

    private val viewModel : CoinViewModel by viewModels()
    private lateinit var binding: FragmentCoinsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCoinsBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchCoinsApi()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.apply {
            viewModel.data.observe(viewLifecycleOwner, {
                rvCoins.apply {
                    adapter = CoinAdapter(it.data, this@CoinsFragment)
                    layoutManager = LinearLayoutManager(requireContext())
                }
            })
        }
    }

    override fun itemClicked(coin: Coin) {
        findNavController().navigate(
            CoinsFragmentDirections.actionCoinsFragmentToCoinItemFragment()
        )
    }
}
package com.example.android_practice_7.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice_7.R
import com.example.android_practice_7.data.remote.model.Coin
import com.example.android_practice_7.databinding.CoinItemBinding

class CoinAdapter(private val coins: List<Coin>, private val listener: ClickListener) : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    class CoinViewHolder(private val binding: CoinItemBinding, private val listener: ClickListener) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Coin) {
           binding.tvCoinSymbol.text = item.symbol
           binding.root.setOnClickListener {
               listener.itemClicked(item)
           }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val binding = CoinItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val currentItem = coins[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return coins.size
    }

}
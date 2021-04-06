package com.example.android_practice_7.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice_7.R
import com.example.android_practice_7.data.remote.model.Coin
import com.example.android_practice_7.databinding.CoinItemBinding

class CoinAdapter(private val coins: List<Coin>, private val listener: ClickListener) : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    class CoinViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val binding = CoinItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coin_item, parent, false)
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = coins[position]
        with(holder) {

            binding.tvCoinSymbol.text  = coin.symbol

            binding.root.setOnClickListener {
                listener.itemClicked(coin)
            }
        }
    }

    override fun getItemCount(): Int {
        return coins.size
    }

}
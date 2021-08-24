package com.stockbit.watchlist

import Data
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class CoinAdapter(
    private val items: ArrayList<Data>,
    private val onItemClick: (Data, Int) -> Unit
): RecyclerView.Adapter<CoinAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root){

        fun <T> bind(item: T){
            binding.setVariable(BR.coin, item)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.item_crypto, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onItemClick
        }
    }

    override fun getItemCount(): Int =
        items.size
}
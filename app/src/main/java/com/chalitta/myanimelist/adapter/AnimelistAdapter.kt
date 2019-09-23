package com.chalitta.myanimelist.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.chalitta.myanimelist.R
import com.chalitta.myanimelist.databinding.ItemListBinding
import com.chalitta.myanimelist.model.RecommendAnime

class AnimelistAdapter : RecyclerView.Adapter<ViewHolder>() {

    private val TAG = "AnimelistAdapter"
    var animeList: List<RecommendAnime> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemListBinding>(layoutInflater, R.layout.item_list, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(animeList[position])
}

    class ViewHolder(val binding : ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecommendAnime) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
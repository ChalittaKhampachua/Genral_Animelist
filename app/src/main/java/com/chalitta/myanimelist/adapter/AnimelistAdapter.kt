package com.chalitta.myanimelist.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.chalitta.myanimelist.R
import com.chalitta.myanimelist.activity.DetailActivity
import com.chalitta.myanimelist.model.RecommendAnime
import com.squareup.picasso.Picasso

class AnimelistAdapter(private val context: Context) : RecyclerView.Adapter<AnimelistAdapter.ViewHolder>() {

    private val TAG = "AnimelistAdapter"
    private var mData: List<RecommendAnime> = ArrayList()

    fun setAnimeList(list: List<RecommendAnime>) {
        this.mData = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: AnimelistAdapter.ViewHolder, position: Int) {

        Picasso.get()
            .load(mData[position].image_url)
            .fit()
            .centerCrop()
            .placeholder(R.color.colorAccent)
            .error(R.color.colorPrimary)
            .into(holder.iv_photo)

        holder.tv_name.text = mData[position].title

        holder.itemView.setOnClickListener {
            val mIntent = Intent(context, DetailActivity::class.java)
            mIntent.putExtra("mal_id", mData[position].mal_id)
            mIntent.putExtra("url", mData[position].url)
            mIntent.putExtra("image_url", mData[position].image_url)
            mIntent.putExtra("title", mData[position].title)
            mIntent.putExtra("recommendation_url", mData[position].recommendation_url)
            mIntent.putExtra("recommendation_count", mData[position].recommendation_count)
            context.startActivity(mIntent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv_photo: ImageView = itemView.findViewById(R.id.iv_photo)
        val tv_name: TextView = itemView.findViewById(R.id.tv_name)
    }
}
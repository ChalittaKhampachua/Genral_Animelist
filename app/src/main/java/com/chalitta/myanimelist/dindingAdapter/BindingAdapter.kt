package com.chalitta.myanimelist.BindingAdapter

import android.content.Intent
import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.chalitta.myanimelist.activity.DetailActivity
import com.chalitta.myanimelist.adapter.AnimelistAdapter
import com.chalitta.myanimelist.model.RecommendAnime
import com.chalitta.myanimelist.viewmodel.AnimeViewModel
import com.squareup.picasso.Picasso


object BindingAdapter {

    @BindingAdapter("imageUrl", "error", "placeholder")
    @JvmStatic
    fun ImageView.loadImage(url: String, error: Drawable, placeholder: Drawable) {
        Picasso.get()
                .load(url)
                .fit()
                .centerCrop()
                .placeholder(placeholder)
                .error(error)
                .into(this)
    }

    @BindingAdapter("onClickListener")
    @JvmStatic
    fun CardView.onClick(item: RecommendAnime){
        setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra("dataItem", item)
            it.context.startActivity(intent)
        }
    }

    @BindingAdapter("setAdapters")
    @JvmStatic
    fun RecyclerView.bindAdapter(adapter: AnimelistAdapter?){
        adapter?.let { this.adapter = adapter }
    }
}
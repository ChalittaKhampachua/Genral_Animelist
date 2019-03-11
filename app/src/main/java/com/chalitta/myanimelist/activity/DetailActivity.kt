package com.chalitta.myanimelist.activity

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.chalitta.myanimelist.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val mal_id = intent.getIntExtra("mal_id", 0)
        val url = intent.getStringExtra("url")
        val image_url = intent.getStringExtra("image_url")
        val title = intent.getStringExtra("title")
        val recommendation_url = intent.getStringExtra("recommendation_url")
        val recommendation_count = intent.getIntExtra("recommendation_count", 0)

        setUI(mal_id, url,image_url, title, recommendation_url, recommendation_count)

    }

    @SuppressLint("SetTextI18n")
    private fun setUI(mal_id: Int, url: String?, image_url: String?, title: String?, recommendation_url: String?, recommendation_count: Int) {
        tv_mal_id.text = "mal_id: $mal_id"
        tv_url.text = "url: $url"
        tv_name.text = "title: $title"
        tv_recommendation_url.text = "recommendation_url: $recommendation_url"
        tv_recommendation_count.text = "recommendation_count: $recommendation_count"

        Picasso.get()
            .load(image_url)
            .fit()
            .centerCrop()
            .placeholder(R.color.colorAccent)
            .error(R.color.colorPrimary)
            .into(iv_photo_detail)

    }
}

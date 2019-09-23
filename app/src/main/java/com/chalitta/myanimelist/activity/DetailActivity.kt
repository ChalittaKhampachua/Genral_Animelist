package com.chalitta.myanimelist.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.chalitta.myanimelist.R
import com.chalitta.myanimelist.databinding.ActivityDetailBinding
import com.chalitta.myanimelist.manager.ManagerStateLifecyle
import com.chalitta.myanimelist.model.RecommendAnime


class DetailActivity : AppCompatActivity() {

    private var TAG = "DetailActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail)
        val item = intent.extras?.getSerializable("dataItem") as RecommendAnime
        Log.d(TAG, "item : $item")

        binding.lifecycleOwner = this
        binding.item = item


        //Lifecycle
        val managerStateListener = ManagerStateLifecyle(this, lifecycle)
        managerStateListener.setName(item.title)

    }
}

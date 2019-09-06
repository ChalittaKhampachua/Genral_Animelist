package com.chalitta.myanimelist.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.chalitta.myanimelist.R
import com.chalitta.myanimelist.adapter.AnimelistAdapter
import com.chalitta.myanimelist.viewmodel.AnimeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchData()
        initView()

    }

    private lateinit var adapter: AnimelistAdapter

    private fun initView() {
        adapter = AnimelistAdapter(this)
        val layoutManager = GridLayoutManager(this, 3)
        rv_anime_list.layoutManager = layoutManager
        rv_anime_list.adapter = adapter
    }

    private fun fetchData() {
        val viewModel = ViewModelProviders.of(this).get(AnimeViewModel::class.java)
        val liveData = viewModel.getDataAnimeLiveData()

        liveData.observe(this, Observer {anime ->
            anime?.let {
                adapter.setAnimeList(it.recommendations)
                adapter.notifyDataSetChanged()
            }
        })
    }
}

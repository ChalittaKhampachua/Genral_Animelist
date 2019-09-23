package com.chalitta.myanimelist.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.chalitta.myanimelist.R
import com.chalitta.myanimelist.viewmodel.AnimeViewModel
import kotlinx.android.synthetic.main.activity_history.*
import org.koin.android.viewmodel.ext.android.viewModel

class HistoryActivity : AppCompatActivity() {

    private val TAG = "HistoryActivity"
    private val viewModel: AnimeViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        viewModel.getHistory(lv_history)
    }
}

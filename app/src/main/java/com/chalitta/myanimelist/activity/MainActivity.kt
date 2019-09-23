package com.chalitta.myanimelist.activity

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.chalitta.myanimelist.R
import com.chalitta.myanimelist.databinding.ActivityMainBinding
import com.chalitta.myanimelist.viewmodel.AnimeViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private val viewModel: AnimeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.fetchData(this)
        viewModel.initSearch(binding.etSearch)
    }

    fun checkString(text: String?): Boolean {
        return text?.let{
            it.length > 5
        }?: (false)
    }
}

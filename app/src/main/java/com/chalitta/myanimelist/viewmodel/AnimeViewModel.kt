package com.chalitta.myanimelist.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.chalitta.myanimelist.repository.AnimeLiveData
import com.chalitta.myanimelist.model.DataAnime

class AnimeViewModel : ViewModel() {

    val listData = AnimeLiveData()

    fun getDataAnimeLiveData(): LiveData<DataAnime> {
        return listData
    }
}
package com.chalitta.myanimelist.repository

import android.arch.lifecycle.LiveData
import android.util.Log
import com.chalitta.myanimelist.model.DataAnime
import com.chalitta.myanimelist.remote.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimeLiveData(val URL:String) : LiveData<DataAnime>() {

    private val TAG = "AnimeLiveData"

    override fun onActive() {
        Retrofit().getRetroInstance(URL).getRecommentAnime().enqueue(object : Callback<DataAnime> {
            override fun onResponse(call: Call<DataAnime>, response: Response<DataAnime>) {
                Log.d(TAG, "onResponse : $response")
                response.body()?.also {
                    value = it
                }
            }

            override fun onFailure(call: Call<DataAnime>, t: Throwable) {
                Log.d(TAG, "onFailure : ${t.message}")
            }

        })
    }

    override fun onInactive() {
        super.onInactive()

    }
}
package com.chalitta.myanimelist.remote

import com.chalitta.myanimelist.model.DataAnime
import retrofit2.Call
import retrofit2.http.GET

interface ServerApi {

    @GET("recommendations")
    fun getRecommentAnime(): Call<DataAnime>
}
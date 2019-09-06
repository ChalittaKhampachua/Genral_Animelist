package com.chalitta.myanimelist.remote

import com.chalitta.myanimelist.model.DataAnime
import io.reactivex.Observable
import retrofit2.http.GET

interface ServerApi {

    @GET("recommendations")
    fun getRecommentAnime(): Observable<DataAnime>
}
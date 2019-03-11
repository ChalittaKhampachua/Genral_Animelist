package com.chalitta.myanimelist.remote

import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

    private fun getRetroInstance(url: String): retrofit2.Retrofit {

        val gson = GsonBuilder().setLenient().create()
        return retrofit2.Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun getAPIService(url: String) : ServerApi {
        return getRetroInstance(url).create<ServerApi>(ServerApi::class.java)
    }
}
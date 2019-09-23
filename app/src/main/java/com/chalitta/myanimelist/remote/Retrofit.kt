package com.chalitta.myanimelist.remote

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

     fun getRetroInstance(url: String): ServerApi {

        val gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

         return retrofit.create<ServerApi>(ServerApi::class.java)
    }
}
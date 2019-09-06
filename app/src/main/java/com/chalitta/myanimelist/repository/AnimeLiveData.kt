package com.chalitta.myanimelist.repository

import android.arch.lifecycle.LiveData
import android.util.Log
import com.chalitta.myanimelist.global.BASEURL
import com.chalitta.myanimelist.model.DataAnime
import com.chalitta.myanimelist.remote.Retrofit
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class AnimeLiveData : LiveData<DataAnime>() {

    private val TAG = "AnimeLiveData"

    override fun onActive() {
//        val call = Retrofit().getAPIService(BASEURL).getRecommentAnime()
//        call.enqueue(object : Callback<DataAnime> {
//            override fun onResponse(call: Call<DataAnime>, response: Response<DataAnime>) {
//                Log.d(TAG, "onResponse : $response")
//                response.body()?.also {
//                    value = it
//                }
//            }
//
//            override fun onFailure(call: Call<DataAnime>, t: Throwable) {
//                Log.d(TAG, "onFailure : ${t.message}")
//            }
//
//        })

        Retrofit().getRetroInstance(BASEURL).getRecommentAnime()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(object: Observer<DataAnime> {
                    override fun onComplete() {
                        Log.d(TAG, "onComplete")
                    }

                    override fun onSubscribe(d: Disposable) {
                        Log.d(TAG, "onSubscribe")
                    }

                    override fun onNext(t: DataAnime) {
                        value = t
                    }

                    override fun onError(e: Throwable) {
                        Log.d(TAG, "onError : ${e.message}")
                    }

                })
    }

    override fun onInactive() {
        super.onInactive()

    }
}
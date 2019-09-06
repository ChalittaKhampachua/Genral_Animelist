package com.chalitta.myanimelist.manager

import android.app.Activity
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent

class ManagerStateLifecyle(private val mActivity: Activity, lifecycle: Lifecycle) : LifecycleObserver {

    private var mlifecyle: Lifecycle? = null
    private lateinit var mToolbarName:String
    init {
        this.mlifecyle = lifecycle
        lifecycle.addObserver(this)
    }

    fun setName(name:String){
        mToolbarName = name
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start(){
        mActivity.title = mToolbarName
    }

}
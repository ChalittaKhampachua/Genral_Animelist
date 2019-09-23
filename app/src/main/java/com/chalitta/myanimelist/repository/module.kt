package com.chalitta.myanimelist.repository

import com.chalitta.myanimelist.room.AppDatabase
import com.chalitta.myanimelist.viewmodel.AnimeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{

    single { AppDatabase.getAppDatabase(get()) }
    single { Constant() }
    viewModel { AnimeViewModel(get(), get()) }
}
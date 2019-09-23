package com.chalitta.myanimelist.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HistoryEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    companion object {
        fun getAppDatabase(context: Context) : AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "history_db").build()
        }
    }

    abstract fun historyDao(): HistoryDao
}
package com.chalitta.myanimelist.room

import android.arch.lifecycle.LiveData
import androidx.room.*

@Dao
interface HistoryDao{
    @Insert
    fun insertHistory(historyEntity: HistoryEntity)

    @Update
    fun updateHistory(historyEntity: HistoryEntity)

    @Delete
    fun deleteHistory(historyEntity: HistoryEntity)

    @Query("SELECT * FROM history")
    fun getHistoryAll(): List<HistoryEntity>
}
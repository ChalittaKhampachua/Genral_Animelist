package com.chalitta.myanimelist.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class HistoryEntity (
        @PrimaryKey(autoGenerate = true) var id: Int? = null,
        var textSearch: String? = null,
        var dateSearch: String? = null
        )

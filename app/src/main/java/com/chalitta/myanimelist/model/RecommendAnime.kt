package com.chalitta.myanimelist.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RecommendAnime (@SerializedName("mal_id") val mal_id: Int,
                           @SerializedName("url") val url: String,
                           @SerializedName("image_url") val image_url: String,
                           @SerializedName("recommendation_url") val recommendation_url: String,
                           @SerializedName("title") val title: String,
                           @SerializedName("recommendation_count") val recommendation_count: Int) : Serializable
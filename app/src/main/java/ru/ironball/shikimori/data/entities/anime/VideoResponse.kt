package ru.ironball.shikimori.data.entities.anime

import com.google.gson.annotations.SerializedName

class VideoResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("url") val url: String,
    @SerializedName("player_url") val playerUrl: String,
    @SerializedName("name") val name: String?,
    @SerializedName("kind") val kind: String,
    @SerializedName("hosting") val hosting: String,
)

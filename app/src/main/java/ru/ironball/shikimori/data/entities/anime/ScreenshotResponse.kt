package ru.ironball.shikimori.data.entities.anime

import com.google.gson.annotations.SerializedName

class ScreenshotResponse(
    @SerializedName("original") val original: String,
    @SerializedName("preview") val preview: String,
)
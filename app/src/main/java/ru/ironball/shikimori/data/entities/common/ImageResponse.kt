package ru.ironball.shikimori.data.entities.common

import com.google.gson.annotations.SerializedName

class ImageResponse(
    @SerializedName("original") val original: String,
    @SerializedName("preview") val preview: String,
    @SerializedName("x96") val x96: String,
    @SerializedName("x48") val x48: String,
)
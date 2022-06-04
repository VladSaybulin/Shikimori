package ru.ironball.shikimori.data.entities.common

import com.google.gson.annotations.SerializedName

class GenreResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("russian") val russianName: String?,
    @SerializedName("kind") val kind: String
)
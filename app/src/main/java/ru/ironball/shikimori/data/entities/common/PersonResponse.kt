package ru.ironball.shikimori.data.entities.common

import com.google.gson.annotations.SerializedName
import ru.ironball.shikimori.domain.entities.common.Image

class PersonResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("russian") val russianName: String,
    @SerializedName("image") val image: Image,
    @SerializedName("url") val url: String
)
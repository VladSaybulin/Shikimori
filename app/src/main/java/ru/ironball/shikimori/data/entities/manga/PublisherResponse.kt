package ru.ironball.shikimori.data.entities.manga

import com.google.gson.annotations.SerializedName

class PublisherResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
)
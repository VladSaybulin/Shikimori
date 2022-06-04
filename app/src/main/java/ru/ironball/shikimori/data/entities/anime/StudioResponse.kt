package ru.ironball.shikimori.data.entities.anime

import com.google.gson.annotations.SerializedName

class StudioResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("filtered_name") val filteredName: String,
    @SerializedName("real") val real: Boolean,
    @SerializedName("image") val image: String?,
)
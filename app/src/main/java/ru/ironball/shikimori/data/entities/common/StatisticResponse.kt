package ru.ironball.shikimori.data.entities.common

import com.google.gson.annotations.SerializedName

class StatisticResponse(
    @SerializedName("name") val name: String,
    @SerializedName("value") val value: Int,
)
package ru.ironball.shikimori.domain.entities.common

import com.google.gson.annotations.SerializedName

enum class RateStatus(val value: String) {
    @SerializedName("watching")
    WATCHING("watching"),

    @SerializedName("planned")
    PLANNED("planned"),

    @SerializedName("rewatching")
    REWATCHING("rewatching"),

    @SerializedName("completed")
    COMPLETED("completed"),

    @SerializedName("on_hold")
    ON_HOLD("on_hold"),

    @SerializedName("dropped")
    DROPPED("dropped");
}
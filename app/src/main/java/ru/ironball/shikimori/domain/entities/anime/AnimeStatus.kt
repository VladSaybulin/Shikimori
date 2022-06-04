package ru.ironball.shikimori.domain.entities.anime

import com.google.gson.annotations.SerializedName

enum class AnimeStatus(val value: String) {
    @SerializedName("anons")
    ANONS("anons"),

    @SerializedName("ongoing")
    ONGOING("ongoing"),

    @SerializedName("released")
    RELEASED("released"),

    @SerializedName("")
    NONE("none");
}
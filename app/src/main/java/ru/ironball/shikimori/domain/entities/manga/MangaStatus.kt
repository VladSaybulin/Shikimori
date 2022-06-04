package ru.ironball.shikimori.domain.entities.manga

import com.google.gson.annotations.SerializedName

enum class MangaStatus(val shikimoriValue: String) {
    @SerializedName("anons")
    ANONS("anons"),

    @SerializedName("ongoing")
    ONGOING("ongoing"),

    @SerializedName("released")
    RELEASED("released"),

    @SerializedName("paused")
    PAUSED("paused"),

    @SerializedName("discontinued")
    DISCONTINUED("discontinued"),

    @SerializedName("latest")
    LATEST("latest"),

    @SerializedName("")
    NONE("none"); //May be remove
}
package ru.ironball.shikimori.domain.entities.anime

import com.google.gson.annotations.SerializedName

enum class AnimeKind(val value: String) {
    @SerializedName("tv")
    TV("tv"),

    @SerializedName("movie")
    MOVIE("movie"),

    @SerializedName("ova")
    OVA("ova"),

    @SerializedName("ona")
    ONA("ona"),

    @SerializedName("special")
    SPECIAL("special"),

    @SerializedName("music")
    MUSIC("music"),

    @SerializedName("")
    NONE("none");
}
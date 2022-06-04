package ru.ironball.shikimori.domain.entities.manga

import com.google.gson.annotations.SerializedName

enum class MangaKind(val shikimoriValue: String) {
    @SerializedName("manga")
    MANGA("manga"),

    @SerializedName("manhwa")
    MANHWA("manhwa"),

    @SerializedName("manhua")
    MANHUA("manhua"),

    @SerializedName("one_shot")
    ONE_SHOT("one_shot"),

    @SerializedName("doujin)")
    DOUJIN("doujin"),

    @SerializedName("light_novel")
    RANOBE("light_novel"),

    @SerializedName("novel")
    NOVEL("novel"),

    @SerializedName("")
    NONE("none");
}
package ru.ironball.shikimori.domain.entities.common

import com.google.gson.annotations.SerializedName

enum class AgeRating(val value: String) {
    @SerializedName("none")
    NONE("none"),

    @SerializedName("g")
    G("g"),

    @SerializedName("pg")
    PG("pg"),

    @SerializedName("pg_13")
    PG_13("pg_13"),

    @SerializedName("r")
    R17("r"),

    @SerializedName("r_plus")
    R_PLUS("r_plus"),

    @SerializedName("rx")
    RX("rx");
}
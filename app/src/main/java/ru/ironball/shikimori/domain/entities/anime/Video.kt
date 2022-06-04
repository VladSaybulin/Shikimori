package ru.ironball.shikimori.domain.entities.anime

class Video (
    val id: Int,
    val url: String,
    val playerUrl: String,
    val name: String?,
    val kind: String, //Maybe to enum class
    val hosting: String,
)

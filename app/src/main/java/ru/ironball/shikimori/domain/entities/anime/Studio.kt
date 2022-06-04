package ru.ironball.shikimori.domain.entities.anime

class Studio(
    val id: Int,
    val name: String,
    val filteredName: String,
    val real: Boolean,
    val image: String?,
)
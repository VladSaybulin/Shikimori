package ru.ironball.shikimori.domain.entities.common

class Genre(
    val id: String,
    val name: String,
    val russianName: String?,
    val kind: String
) {
    val russianOrOriginalName = russianName ?: name
}
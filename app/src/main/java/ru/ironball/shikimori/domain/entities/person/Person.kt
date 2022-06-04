package ru.ironball.shikimori.domain.entities.person

import ru.ironball.shikimori.domain.entities.common.Image

class Person(
    val id: Long,
    val name: String,
    val russianName: String?,
    val image: Image,
    val url: String
) {
    val russianOrOriginalName = russianName ?: name
}
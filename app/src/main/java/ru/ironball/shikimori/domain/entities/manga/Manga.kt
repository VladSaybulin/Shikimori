package ru.ironball.shikimori.domain.entities.manga

import ru.ironball.shikimori.domain.entities.common.Image
import java.util.*

class Manga(
    val id: Long,
    val name: String,
    val russianName: String?,
    val image: Image,
    val url: String,
    val kind: MangaKind,
    val status: MangaStatus,
    val score: Float,
    val volumes: Int,
    val chapters: Int,
    val dateAired: Calendar?,
    val dateReleased: Calendar?,
) {
    val russianOrOriginalName = russianName ?: name
}
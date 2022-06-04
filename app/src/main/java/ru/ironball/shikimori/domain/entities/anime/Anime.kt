package ru.ironball.shikimori.domain.entities.anime

import ru.ironball.shikimori.domain.entities.common.Image
import java.util.*

class Anime(
    val id: Long,
    val name: String,
    val russianName: String?,
    val image: Image,
    val url: String,
    val kind: AnimeKind,
    val status: AnimeStatus,
    val score: Float,
    val episodes: Int,
    val episodesAired: Int,
    val dateAired: Calendar?,
    val dateReleased: Calendar?,
) {
    val russianOrOriginalName = russianName ?: name
}
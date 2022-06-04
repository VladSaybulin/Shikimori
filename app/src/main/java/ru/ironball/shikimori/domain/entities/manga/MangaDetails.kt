package ru.ironball.shikimori.domain.entities.manga

import ru.ironball.shikimori.domain.entities.common.Genre
import ru.ironball.shikimori.domain.entities.common.Image
import ru.ironball.shikimori.domain.entities.common.Statistic
import java.util.*

class MangaDetails(
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
    val dateAired: Date?,
    val dateReleased: Date?,
    val englishNames: List<String>?,
    val japaneseNames: List<String>?,
    val synonymNames: List<String>,
    val licenseName: String?,
    val description: String?,
    val descriptionHtml: String,
    val descriptionSource: String?,
    val franchise: String?,
    val isFavorite: Boolean,
    val genres: List<Genre>,
    val publishers: List<Publisher>,
    val threadId: Int,
    val topicId: Int,
    val rateScoreStats: List<Statistic>,
    val rateStatusStats: List<Statistic>,
) {
    val russianOrOriginalName = russianName ?: name
}
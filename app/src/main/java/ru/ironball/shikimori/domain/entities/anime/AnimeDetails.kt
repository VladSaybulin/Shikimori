package ru.ironball.shikimori.domain.entities.anime

import ru.ironball.shikimori.domain.entities.common.AgeRating
import ru.ironball.shikimori.domain.entities.common.Genre
import ru.ironball.shikimori.domain.entities.common.Image
import ru.ironball.shikimori.domain.entities.common.Statistic
import java.util.*

class AnimeDetails(
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
    val dateAired: Date?,
    val dateReleased: Date?,
    val ageRating: AgeRating,
    val dateNextEpisode: Date?,
    val englishNames: List<String>?,
    val japaneseNames: List<String>?,
    val synonymNames: List<String>,
    val licenseName: String?,
    val duration: Int,
    val description: String?,
    val descriptionHtml: String,
    val descriptionSource: String?,
    val franchise: String?,
    val isFavorite: Boolean,
    val genres: List<Genre>,
    val studios: List<Studio>,
    val threadId: Int,
    val topicId: Int,
    val rateScoreStats: List<Statistic>,
    val rateStatusStats: List<Statistic>,
    val videos: List<Video>,
    val screenshots: List<Screenshot>,
    val licensors: List<String>,
    val subbers: List<String>,
    val dubbers: List<String>,
    //val userRate: UserRate
) {

    val russianOrOriginalName = russianName ?: name

}

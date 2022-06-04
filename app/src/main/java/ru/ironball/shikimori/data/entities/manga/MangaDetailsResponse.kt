package ru.ironball.shikimori.data.entities.manga

import com.google.gson.annotations.SerializedName
import ru.ironball.shikimori.data.entities.common.GenreResponse
import ru.ironball.shikimori.data.entities.common.ImageResponse
import ru.ironball.shikimori.data.entities.common.StatisticResponse
import ru.ironball.shikimori.data.entities.common.UserRateResponse
import ru.ironball.shikimori.domain.entities.manga.MangaKind
import ru.ironball.shikimori.domain.entities.manga.MangaStatus
import java.util.*

class MangaDetailsResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("russian") val russianName: String,
    @SerializedName("image") val image: ImageResponse,
    @SerializedName("url") val url: String,
    @SerializedName("kind") val kind: MangaKind?,
    @SerializedName("score") val score: Float,
    @SerializedName("status") val status: MangaStatus,
    @SerializedName("volumes") val volumes: Int,
    @SerializedName("chapters") val chapters: Int,
    @SerializedName("aired_on") val dateAired: Date?,
    @SerializedName("released_on") val dateReleased: Date?,
    @SerializedName("english") val englishNames: List<String?>?,
    @SerializedName("japanese") val japaneseNames: List<String?>?,
    @SerializedName("synonyms") val synonymsNames: List<String>,
    @SerializedName("license_name_ru") val licenseName: String,
    @SerializedName("description") val description: String?,
    @SerializedName("description_html") val descriptionHtml: String,
    @SerializedName("description_source") val descriptionSource: String?,
    @SerializedName("franchise") val franchise: String?,
    @SerializedName("favoured") val favoured: Boolean,
    @SerializedName("thread_id") val threadId: Int,
    @SerializedName("topic_id") val topicId: Int,
    @SerializedName("rates_scores_stats") val ratesScoresStats: List<StatisticResponse>,
    @SerializedName("rates_statuses_stats") val ratesStatusesStats: List<StatisticResponse>,
    @SerializedName("updated_at") val updatedDate: Date?,
    @SerializedName("genres") val genres: List<GenreResponse>,
    @SerializedName("publishers") val publishers: List<PublisherResponse>,
    @SerializedName("user_rate") val userRate: UserRateResponse?,
)
package ru.ironball.shikimori.data.entities.anime

import com.google.gson.annotations.SerializedName
import ru.ironball.shikimori.data.entities.common.ImageResponse
import ru.ironball.shikimori.domain.entities.anime.AnimeKind
import ru.ironball.shikimori.domain.entities.anime.AnimeStatus
import java.util.*

class AnimeResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("russian") val russianName: String,
    @SerializedName("image") val image: ImageResponse,
    @SerializedName("url") val url: String,
    @SerializedName("kind") val kind: AnimeKind?,
    @SerializedName("status") val status: AnimeStatus?,
    @SerializedName("score") val score: Float,
    @SerializedName("episodes") val episodes: Int,
    @SerializedName("aired_episodes") val airedEpisodes: Int,
    @SerializedName("aired_on") val dateAired: Date?,
    @SerializedName("released_on") val dateReleased: Date?,
)
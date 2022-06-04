package ru.ironball.shikimori.data.entities.manga

import com.google.gson.annotations.SerializedName
import ru.ironball.shikimori.data.entities.common.ImageResponse
import ru.ironball.shikimori.domain.entities.manga.MangaKind
import ru.ironball.shikimori.domain.entities.manga.MangaStatus
import java.util.*

class MangaResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("russian") val russianName: String,
    @SerializedName("image") val image: ImageResponse,
    @SerializedName("url") val url: String,
    @SerializedName("kind") val kind: MangaKind?,
    @SerializedName("status") val status: MangaStatus?,
    @SerializedName("score") val score: Float,
    @SerializedName("volumes") val volumes: Int,
    @SerializedName("chapters") val chapters: Int,
    @SerializedName("aired_on") val dateAired: Date?,
    @SerializedName("released_on") val dateReleased: Date?,
)
package ru.ironball.shikimori.data.entities.common

import com.google.gson.annotations.SerializedName
import ru.ironball.shikimori.domain.entities.common.RateStatus
import java.util.*

class UserRateResponse(
    @SerializedName("id") val id: Long? = null,
    @SerializedName("score") val score: Float? = null,
    @SerializedName("status") val status: RateStatus? = null,
    @SerializedName("text") val text: String? = null,
    @SerializedName("episodes") val episodes: Int? = null,
    @SerializedName("chapters") val chapters: Int? = null,
    @SerializedName("volumes") val volumes: Int? = null,
    @SerializedName("text_html") val textHtml: String? = null,
    @SerializedName("rewatches") val rewatches: Int? = null,
    @SerializedName("created_at") val dateCreated: Date? = null,
    @SerializedName("updated_at") val dateUpdated: Date? = null
)